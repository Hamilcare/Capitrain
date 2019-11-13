package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static final String inputDirPath = "./resources/input/";
	public static final String[] files = { "pi100000digit", "piOneMillion", "cinquante_millions" };
	public static final String[] patterns = { "increasing", };
	private static String jarPath;
	private static String jarName;
	private static String benchDirectory;

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length < 1) {
			throw new IllegalArgumentException("Missing parameter: path to jar executable ");
		}
		jarPath = args[0];

		// Create directory for benchmark outputs
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		benchDirectory = "./benchmarks/" + date;
		new File(benchDirectory).mkdirs();

		// Get length of each file
		int[] filesSize = new int[files.length];
		for (int i = 0; i < files.length; i++) {
			String content = new String(Files.readAllBytes(Paths.get(inputDirPath + files[i])));
			filesSize[i] = content.length();
		}

		// Benchmarck for each feature
		for (int featureIndex = 0; featureIndex < patterns.length; featureIndex++) {
			List<String> csvLines = new ArrayList();
			csvLines.add("length;duration");
			for (int fileIndex = 0; fileIndex < filesSize.length; fileIndex++) {
				long delay = benchFile(files[fileIndex], patterns[featureIndex]);
				csvLines.add(filesSize[fileIndex] + ";" + delay);
			}
			writeCsv(patterns[featureIndex], csvLines);
		}

	}

	private static long benchFile(String file, String pattern) throws IOException, InterruptedException {

		String confAbsolutePath = new File("./resources/config/regex.config").getCanonicalPath();

		try {
			long startTranslation = System.currentTimeMillis();
			String filePath = new File(inputDirPath + file).getCanonicalPath();
			ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarPath, "-p " + pattern, "-f one", "-a sum",
					"-d " + filePath, "-c " + confAbsolutePath);
			pb.inheritIO();
			Process p = pb.start();

			p.waitFor();
			System.out.println(String.join(" ", pb.command()));
			long endTranslation = System.currentTimeMillis();
			return endTranslation - startTranslation;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static void writeCsv(String feature, List<String> csvLines) throws IOException {
		FileWriter writer = new FileWriter(benchDirectory + "/" + feature + ".csv");
		for (String line : csvLines) {
			writer.append(line);
			writer.append("\n");
		}
		writer.flush();
		writer.close();
	}

}
