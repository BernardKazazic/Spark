package rokvp.dz04.zad02;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("USNames");
        JavaSparkContext sc = new JavaSparkContext(conf);

        String path = "StateNames.csv";
        JavaRDD<String> records = sc.textFile(path);

        JavaRDD<String> filteredRecords = records.filter(Main::isParsable);
        JavaRDD<USBabyNameRecord> usBabyRecords = filteredRecords.map(Main::parseToUSBabyNameRecord);
        usBabyRecords.cache();

        // 1.
        Tuple2<String, Integer> firstTaskResult = usBabyRecords
                .filter(record -> record.getGender().equals("M"))
                .mapToPair(record -> new Tuple2<>(record.getName(), record.getCount()))
                .reduceByKey(Integer::sum)
                .min(new CountComparator());

        // 2.
        List<Tuple2<String, Integer>> secondTaskResult = usBabyRecords
                .filter(record -> record.getGender().equals("F"))
                .mapToPair(record -> new Tuple2<>(record.getName(), record.getCount()))
                .reduceByKey(Integer::sum)
                .takeOrdered(10, new CountComparator().reversed());

        // 3.
        Tuple2<String, Integer> thirdTaskResult = usBabyRecords
                .filter(record -> record.getYear().equals("1948"))
                .mapToPair(record -> new Tuple2<>(record.getState(), record.getCount()))
                .reduceByKey(Integer::sum)
                .max(new CountComparator());

        // 4.
        List<Tuple2<String, Integer>> fourthTaskResult = usBabyRecords
                .filter(record -> record.getGender().equals("M"))
                .mapToPair(record -> new Tuple2<>(record.getYear(), record.getCount()))
                .reduceByKey(Integer::sum)
                .sortByKey()
                .collect();

        // 5.
        Map<String, Integer> countByYear = usBabyRecords
                .mapToPair(record -> new Tuple2<>(record.getYear(), record.getCount()))
                .reduceByKey(Integer::sum)
                .collectAsMap();

        List<Tuple2<String, String>> fifthTaskResult = usBabyRecords
                .filter(record -> record.getName().equals("Lucy"))
                .mapToPair(record -> new Tuple2<>(record.getYear(), record.getCount()))
                .reduceByKey(Integer::sum)
                .mapToPair(record -> {
                    String key = record._1;
                    double value = ((double)record._2 / (double)countByYear.get(record._1)) * 100;
                    return new Tuple2<>(key, String.format("%.4f%%", value));
                })
                .sortByKey()
                .collect();

        // 6.
        Integer sixthTaskResult = usBabyRecords
                .map(USBabyNameRecord::getCount)
                .reduce(Integer::sum);

        // 7.
        Integer seventhTaskResult = Math.toIntExact(usBabyRecords
                .map(USBabyNameRecord::getName)
                .distinct()
                .count());

        // print results
        System.out.println("1.");
        System.out.println(firstTaskResult);

        System.out.println("2.");
        for(Tuple2<String, Integer> tuple : secondTaskResult) {
            System.out.println(tuple);
        }

        System.out.println("3.");
        System.out.println(thirdTaskResult);

        System.out.println("4.");
        for(Tuple2<String, Integer> tuple : fourthTaskResult) {
            System.out.println(tuple);
        }

        System.out.println("5.");
        for(Tuple2<String, String> tuple : fifthTaskResult) {
            System.out.println(tuple);
        }

        System.out.println("6.");
        System.out.println(sixthTaskResult);

        System.out.println("7.");
        System.out.println(seventhTaskResult);
    }

    public static boolean isParsable(String row) {
        try {
            String[] split = row.split(",");
            Integer.parseInt(split[5]);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static USBabyNameRecord parseToUSBabyNameRecord(String row) {
        String[] split = row.split(",");
        return new USBabyNameRecord(split[0], split[1], split[2], split[3], split[4], Integer.parseInt(split[5]));
    }
}
