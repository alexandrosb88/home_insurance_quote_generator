package Home_Insurance_Quote_Generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class configurationFile {

    public static class Range {
        public int min;
        public int max;
        public double value;

        public Range(int lower, int upper, double value) {
            this.min = lower;
            this.max = upper;
            this.value = value;
        }

    }

    public static List<Range> configData = new ArrayList<>();

    public static void readConfigFile(String filename) {


        try(BufferedReader br = new BufferedReader(new FileReader(filename)))

        {

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int min = Integer.parseInt(values[0]);
                int max = Integer.parseInt(values[1]);
                if (max == -1) {
                    max = Integer.MAX_VALUE; // no upper bound
                }
                double value = Double.parseDouble(values[2]);
                configData.add(new Range (min, max, value));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();


        }

    }

}
