package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import exception.CliArgsException;
import exception.UnavailablePatternException;
import search.RegexSearcher;
import search.aggregator.AggreEnum;
import search.feature.FeatureEnum;
import translate.ITranslator;

public final class ParseCliUtils {

	private static final int REQUESTED_AGGREGATOR = 5;
	private static final int REQUESTED_FEATURE = 3;
	private static final int TIRET_D = 6;
	private static final int TIRET_A = 4;
	private static final int TIRET_F = 2;
	private static final int TIRET_P = 0;
	private static final int REQUESTED_PATTERN = 1;

	/**
	 * args[0] -p <br>
	 * args[1] pattern <br>
	 * args[2] -f <br>
	 * args[3] feature <br>
	 * args[4] -a <br>
	 * args[5] aggregator <br>
	 * args[6] -d <br>
	 * args[7] pathToDatafile <br>
	 * args[8] -c <br>
	 * args[9] pathToPattern <br>
	 * 
	 * @throws CliArgsException
	 */
	public static void parseCLIArgs(String[] args) throws CliArgsException {
		checkArgsLength(args);
		checkPrefixArgs(args);
	}

	public static RegexSearcher preparePatternMatchers(String[] args, ITranslator translator) throws Exception {

		String pattern = getPattern(args);
		FeatureEnum feature = getFeature(args);
		AggreEnum aggregator = getAggregator(args);
		return new RegexSearcher(args[REQUESTED_PATTERN], pattern, translator.getTextToTranslate(),
				translator.getTranslatedText(), feature, aggregator);

	}

	private static AggreEnum getAggregator(String[] args) throws Exception {
		AggreEnum requestedAggregagtor = AggreEnum.getAggregFromString(args[REQUESTED_AGGREGATOR]);
		if (requestedAggregagtor != null) {
			return requestedAggregagtor;
		}
		throw new Exception("Requested Aggregator unavailable");
	}

	private static FeatureEnum getFeature(String[] args) throws Exception {

		FeatureEnum requestedFeature = FeatureEnum.getFeatureFromString(args[REQUESTED_FEATURE]);
		if (requestedFeature != null) {
			return requestedFeature;
		}
		throw new Exception("Requested Feature unavailable");
	}

	private static String getPattern(String[] args) throws IOException, UnavailablePatternException {
		String requestedPattern = args[REQUESTED_PATTERN].toUpperCase();
		BufferedReader br = Files.newBufferedReader(Paths.get(args[9]));
		Map<String, String> availableConf = new HashMap<>();
		br.lines().forEach(line -> {
			String[] confLine = line.split(";");
			availableConf.put(confLine[0].toUpperCase().trim(), confLine[1].trim());
		});

		if (availableConf.containsKey(requestedPattern)) {
			return availableConf.get(requestedPattern);
		} else {
			throw new UnavailablePatternException(requestedPattern + "unavailable");
		}

	}

	private static void checkArgsLength(String[] args) throws CliArgsException {
		if (args.length < 10) {
			throw new CliArgsException("Not enough args");
		}
	}

	public static void checkPrefixArgs(String[] args) throws CliArgsException {
		if (!("-p".equals(args[TIRET_P]) && "-f".equals(args[TIRET_F]) && "-a".equals(args[TIRET_A])
				&& "-d".equals(args[TIRET_D]) && "-c".equals(args[8]))) {
			throw new CliArgsException("Malformated cli call");
		}
	}

	public static String getPathToDataFile(String[] args) {

		return args[7];
	}
}
