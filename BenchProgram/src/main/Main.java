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
	public static final String inputDirPath = "./BenchProgram/resources/input/";
	public static final String[] files = { "10.digt", "100.digt", "1000.digt", "10000.digt", "100000.digt",
			"1000000.digt", "5000000.digt", "10000000.digt", "50000000.digt", "100000000.digt" };
//    public static final String[] patterns = { "increasing", "increasing_sequence", "increasing_terrace", "summit",
//            "plateau", "proper_plateau", "strictly_increasing_sequence", "peak", "inflexion", "steady",
//            "steady_sequence", "zigzag" };
    public static final String patternsDirectory = "./AutomationV2/resources/pattern/";
    public static final String[] patterns = { "peak.csv" };
	public static final String[] features = { "one", "width", "surf", "max", "min" };
	public static final String[] aggregators = { "max", "min" };
	private static String jarPath;
	private static String jarName;
	private static String benchDirectory;
	private static int[] filesSizes;

	private static final int NB_TRY = 1;

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length < 1) {
			throw new IllegalArgumentException("Missing parameter: path to jar executable ");
		}
		jarPath = args[0];

		// Create directory for benchmark outputs
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		benchDirectory = "./benchmarks/" + date;
		new File(benchDirectory).mkdirs();

		filesSizes = new int[files.length];
		for (int i = 0; i < files.length; i++) {
			String content = new String(Files.readAllBytes(Paths.get(inputDirPath + files[i])));
			filesSizes[i] = content.length();
		}

		if (args.length == 5) {
			benchFeatureAndAggregation(args);
		} else {
			// Benchmarck for each feature
			for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
				for (int featureIndex = 0; featureIndex < features.length; featureIndex++) {
					for (int aggregatorIndex = 0; aggregatorIndex < aggregators.length; aggregatorIndex++) {
						System.out.println("COUCOU : " + String.format("%s-%s-%s", patterns[patternIndex],
								features[featureIndex], aggregators[aggregatorIndex]));
						List<String> csvLines = new ArrayList<>();
						csvLines.add("length;duration");
						for (int fileIndex = 0; fileIndex < filesSizes.length; fileIndex++) {
							long delay = benchFile(files[fileIndex], patternsDirectory + patterns[patternIndex], features[featureIndex],
									aggregators[aggregatorIndex]);
							csvLines.add(filesSizes[fileIndex] + ";" + delay);
						}
						writeCsv(String.format("%s-%s-%s", patterns[patternIndex], features[featureIndex],
								aggregators[aggregatorIndex]), csvLines);
					}

				}
			}
		}
	}

	private static void benchFeatureAndAggregation(String[] args) throws IOException, InterruptedException {
		String feature = args[2];
		String aggregation = args[4];
		List<String> resultats = new ArrayList<>();
		for (String pattern : patterns) {
			resultats.add(pattern);
			for (int fileIndex = 0; fileIndex < filesSizes.length; fileIndex++) {
				resultats.add(filesSizes[fileIndex] + ";" + benchFile(files[fileIndex], pattern, feature, aggregation));
			}
			resultats.add("\n");
		}
		writeCsv(String.format("%s-%s-%s", "all-patterns", feature, aggregation), resultats);
	}

	private static long benchFile(String file, String patternFile, String feature, String aggregator)
			throws IOException, InterruptedException {
		try {
			long startTranslation = System.currentTimeMillis();
			for (int i = 0; i < NB_TRY; i++) {
				String filePath = new File(inputDirPath + file).getCanonicalPath();
				Runtime rt = Runtime.getRuntime();
				String commandLine = "java -Xmx14G -jar " + jarPath + " " + patternFile + " " + aggregator + " " + feature + " " + filePath;
				System.out.println(commandLine);
				Process pro = rt.exec(commandLine);

				pro.waitFor();
			}

			long endTranslation = System.currentTimeMillis();
			return (endTranslation - startTranslation) / NB_TRY;
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
