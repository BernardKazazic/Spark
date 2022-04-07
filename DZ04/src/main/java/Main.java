import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("DZ04")
                .getOrCreate();

        String path = "StateNames.csv";

        Dataset<Row> df = spark.read().option("delimiter", ",").option("header", "true").csv(path);
        df.show();
    }
}
