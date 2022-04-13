package rokvp.dz04.zad01;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path dirPath = Path.of("sensorscope-monitor");
        Path destPath = Path.of("sensorscope-monitor-all.csv");
        Stream<String> lines;

        try {
            lines = Files.list(dirPath).flatMap(ThrowingFunction.wrap(Files::lines));
            lines = lines.filter(Main::isParsable);
            Stream<SensorscopeReading> sensorscopeReadings = lines.map(Main::parseToSensorscopeReading).sorted(new DateComparator());
            Files.deleteIfExists(destPath);
            Files.createFile(destPath);
            BufferedWriter bw = Files.newBufferedWriter(destPath);

            for(SensorscopeReading reading : sensorscopeReadings.collect(Collectors.toList())) {
                bw.write(reading.toString());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isParsable(String line) {
        try {
            String[] split = line.split(" ");
            Integer.parseInt(split[1]);
            Integer.parseInt(split[2]);
            Integer.parseInt(split[3]);
            Integer.parseInt(split[4]);
            Integer.parseInt(split[5]);
            Integer.parseInt(split[6]);
            Double.parseDouble(split[7]);
            Double.parseDouble(split[8]);
            Double.parseDouble(split[9]);
            Double.parseDouble(split[10]);
            Double.parseDouble(split[11]);
            Double.parseDouble(split[12]);
            Double.parseDouble(split[13]);
            Double.parseDouble(split[14]);
            Double.parseDouble(split[15]);
            Double.parseDouble(split[16]);
            Double.parseDouble(split[17]);
            Double.parseDouble(split[18]);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static SensorscopeReading parseToSensorscopeReading(String line) {
        String[] split = line.split(" ");
        return new SensorscopeReading(
                split[0],
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                Integer.parseInt(split[3]),
                Integer.parseInt(split[4]),
                Integer.parseInt(split[5]),
                Integer.parseInt(split[6]),
                Double.parseDouble(split[7]),
                Double.parseDouble(split[8]),
                Double.parseDouble(split[9]),
                Double.parseDouble(split[10]),
                Double.parseDouble(split[11]),
                Double.parseDouble(split[12]),
                Double.parseDouble(split[13]),
                Double.parseDouble(split[14]),
                Double.parseDouble(split[15]),
                Double.parseDouble(split[16]),
                Double.parseDouble(split[17]),
                Double.parseDouble(split[18]));
    }
}
