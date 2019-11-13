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
            "pi100000digit"
    };
    public static final String[] patterns = {
            "increasing",
            };
    private static String jarPath;
    private static String jarName;
    private static String benchDirectory;

    public static void Main(String[] args) throws IOException{

        if(args.length < 1){
            throw new IllegalArgumentException("Missing parameter: path to directory containing jar executable ");
        }
        if(args.length < 2){
            throw new IllegalArgumentException("Missing parameter: jar executable name");
        }
        jarPath = args[0];
        jarName = args[1];

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
        for (int featureIndex = 0; featureIndex < patterns.length; featureIndex++) {
            List<String> csvLines = new ArrayList();
            csvLines.add("length;duration");
            for(int fileIndex = 0 ; fileIndex < filesSize.length ; fileIndex++){
                long delay = benchFile(files[fileIndex], patterns[featureIndex]);
                csvLines.add(filesSize[fileIndex] + ";" + delay);
            }
            writeCsv(patterns[featureIndex], csvLines);
        }

    }

    private static long benchFile(String file, String feature) throws IOException{
        long startTranslation = System.currentTimeMillis();

        String confAbsolutePath = new File("./resources/config/regex.conf").getAbsolutePath();

        ProcessBuilder pb = new ProcessBuilder(jarPath, "-jar", jarName, "-p " + feature, "-f one", "-a sum", "-d " + Paths.get(inputDirPath, file).toAbsolutePath().toString(), "-c " + confAbsolutePath);
        Process p = pb.start();

        long endTranslation = System.currentTimeMillis();
        return endTranslation - startTranslation;
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
