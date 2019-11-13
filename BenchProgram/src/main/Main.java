package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static final String inputDirPath = "./resources/input/";
    public static final String[] files = {
            "pi_100",
            "pi_1000",
            "pi_10000",
            "pi_100000",
            "pi_1000000",
            "pi_50000000"
    };
    public static final String[] patterns = {
            "increasing",
            "increasing_sequence",
            "increasing_terrace",
            "summit",
            "plateau",
            "proper_plateau",
            "strictly_increasing_sequence",
            "peak",
            "inflexion",
            "steady",
            "steady_sequence",
            "zigzag"
            };
    public static final String[] features = {
            "one",
            "width",
            "surf",
            "max",
            "min",
            "range"
    };
    public static final String[] aggregators = {
            "max",
            "min",
            "sum"
    };
    private static String jarPath;
    private static String jarName;
    private static String benchDirectory;

    public static void main(String[] args) throws IOException, InterruptedException{

        if(args.length < 1){
            throw new IllegalArgumentException("Missing parameter: path to jar executable ");
        }
        jarPath = args[0];

        //Create directory for benchmark outputs
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        benchDirectory = "./benchmarks/" + date;
        new File(benchDirectory).mkdirs();

        //Get length of each file
        int[] filesSize = new int[files.length];
        for (int i = 0 ; i < files.length; i++) {
            String content = new String(Files.readAllBytes(Paths.get(inputDirPath + files[i])));
            filesSize[i] = content.length();
        }

        //Benchmarck for each feature
        for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
            for(int featureIndex = 0; featureIndex < features.length; featureIndex++){
                for(int aggregatorIndex = 0; aggregatorIndex < aggregators.length; aggregatorIndex++){
                    System.out.println("COUCOU : " + String.format("%s-%s-%s", patterns[patternIndex], features[featureIndex], aggregators[aggregatorIndex]));
                    List<String> csvLines = new ArrayList();
                    csvLines.add("length;duration");
                    for(int fileIndex = 0 ; fileIndex < filesSize.length ; fileIndex++){
                        long delay = benchFile(files[fileIndex], patterns[patternIndex], features[featureIndex], aggregators[aggregatorIndex]);
                        csvLines.add(filesSize[fileIndex] + ";" + delay);
                    }
                    writeCsv(String.format("%s-%s-%s", patterns[patternIndex], features[featureIndex], aggregators[aggregatorIndex]), csvLines);
                }

            }
        }

    }

    private static long benchFile(String file, String pattern, String feature, String aggregator) throws IOException, InterruptedException{
        String confAbsolutePath = new File("./resources/config/regex.config").getCanonicalPath();

        try {
            long startTranslation = System.currentTimeMillis();
            String filePath = new File(inputDirPath + file).getCanonicalPath();
            Runtime rt = Runtime.getRuntime();
            Process pro = rt.exec("java -jar " + jarPath + " -p " + pattern + " -f " + feature + " -a " + aggregator + " -d " + filePath + " -c " + confAbsolutePath);
            pro.waitFor();

            long endTranslation = System.currentTimeMillis();
            return endTranslation - startTranslation;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static void writeCsv(String feature, List<String> csvLines) throws IOException{
        FileWriter writer = new FileWriter(benchDirectory + "/" + feature + ".csv");
        for (String line : csvLines) {
            writer.append(line);
            writer.append("\n");
        }
        writer.flush();
        writer.close();
    }

}
