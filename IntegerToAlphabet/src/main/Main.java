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
import search.operator.OperatorEnum;
import search.operator.OperatorFactory;
import translate.ITranslator;
import translate.Translate;

public class Main {

	public static final String CINQUANTE_MILLION = "cinquante_millions";
	
	public static final String UN_MILLION = "piOneMillion";
	public static final String CENT_MILLE = "pi100000digit";
	
	public static final String INPUT_FILE = CENT_MILLE;
	
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}

		// Data source setting
		long startTranslation = System.currentTimeMillis();
		ITranslator translator = piUnMillion();
		long endTranslation = System.currentTimeMillis();

		System.out.println("Traduction en " + (endTranslation - startTranslation) + " ms");

		// Effective translation

		LookForRegex(translator, 4);

	}

	/** Recherche les patterns définis dans la config **/
	public static void LookForRegex(ITranslator translator, int nbProcess) {

		BufferedReader br;
		try {
			br = Files.newBufferedReader(Paths.get("./resources/config/regex.confg"));
			List<String[]> conf = br.lines().map(str -> str.split("\\|\\|")).collect(Collectors.toList());

			Collection<Callable<String>> searchers = new ArrayList<>();
			conf.forEach(pair -> searchers.add(new RegexSearcher(pair[0].trim(), pair[1].trim(),
					translator.getTranslatedText(), OperatorFactory.getOperator(OperatorEnum.MAX_LENGTH))));

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

	/** Lit le nombre pi et le traduit dans l'alphabet **/
	public static ITranslator piUnMillion() {
		try {
			String content = new String(Files.readAllBytes(Paths.get("./resources/input/"+INPUT_FILE)));
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
