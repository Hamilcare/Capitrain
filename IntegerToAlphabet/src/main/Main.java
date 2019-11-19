package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import search.RegexSearcher;
import search.aggregator.AggreEnum;
import search.feature.FeatureEnum;
import translate.ITranslator;
import translate.Translate;

public class Main {

	public static final String CINQ_CENT_MILLION = "xaa";

	public static final String CINQUANTE_MILLION = "cinquante_millions";

	public static final String UN_MILLION = "piOneMillion";

	public static final String CENT_MILLE = "pi100000digit";

	public static final String MILLIARD = "milliard";

	public static final String EXEMPLE = "exemple";

	public static final String INPUT_FILE = UN_MILLION;

	public static final int NB_THREAD = 1;

	public static final boolean IS_DEBUG_ENABLE = true;

	public static void main(String[] args) throws Exception {
		System.out.println("MaxMemory=" + Runtime.getRuntime().maxMemory() / 1000000 + "mo");
		System.out.println("TotalMemory=" + Runtime.getRuntime().totalMemory() / 1000000 + "mo");
		ParseCliUtils.checkPrefixArgs(args);
		String pathToDataFile = ParseCliUtils.getPathToDataFile(args);

		long startTranslation = System.currentTimeMillis();
		ITranslator translator = translateInput(pathToDataFile);
		long endTranslation = System.currentTimeMillis();
		System.out.println("Traduction en " + (endTranslation - startTranslation) + " ms");

		RegexSearcher searcher = ParseCliUtils.preparePatternMatchers(args, translator);

		searcher.run();

//		LookForRegex(translator, NB_THREAD);

	}

	/** Recherche les patterns définis dans la config **/
	public static void LookForRegex(ITranslator translator, int nbProcess) {

		try {
			Collection<Callable<String>> searchers = preparePatternMatchers(translator);

			ExecutorService executorService = Executors.newFixedThreadPool(nbProcess);

			long start = System.currentTimeMillis();
			executorService.invokeAll(searchers);
			executorService.shutdown();
			long end = System.currentTimeMillis();

			System.out.println("nbProcess : " + nbProcess + " elapsed time : " + (end - start));

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * lit le fichier de conf et prépare un pattern matcher par pattern
	 * 
	 * @param translator
	 * @return
	 * @throws IOException
	 */
	private static Collection<Callable<String>> preparePatternMatchers(ITranslator translator) throws IOException {
		BufferedReader br;
		br = Files.newBufferedReader(Paths.get("./resources/config/debug.config"));
		List<String[]> conf = br.lines().map(str -> str.split(";")).collect(Collectors.toList());

		Collection<Callable<String>> searchers = new ArrayList<>();
		conf.forEach(confLine -> searchers.add(new RegexSearcher(confLine[0].trim(), confLine[1].trim(),
				translator.getTextToTranslate(), translator.getTranslatedText(), FeatureEnum.ONE, AggreEnum.SUM)));
		return searchers;
	}

	/**
	 * @see {@link #INPUT_FILE} Lit le nombre pi et le traduit dans l'alphabet
	 **/
	public static ITranslator translateInput(String pathToData) {
		try {
			String content = new String(Files.readAllBytes(Paths.get(pathToData)));
			System.out.println("Text contains " + content.length() + " characters");

			List<Integer> textToTranslate = new ArrayList<>(content.length());
			for (int i = 0; i < content.length(); i++) {
				textToTranslate.add(Character.getNumericValue(content.charAt(i)));
			}

			System.out.println("size array : " + textToTranslate.size());
			ITranslator translator = new Translate(textToTranslate);
			translator.translate();
			System.out.println("Translated");

			return translator;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}

}
