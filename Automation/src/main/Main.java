package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import translation.ITranslator;
import translation.Translate;

public class Main {

	public static final String EXEMPLE = "exemple";
	public static final String CINQUANTE_MILLION = "cinquante_millions";
	public static final String CENT_MILLIONS = "100.000.000.digt";
	public static final String INPUT_FILE = CENT_MILLIONS;

	public static void main(String[] args) {

		long startTranslation = System.currentTimeMillis();

		ITranslator translator = translateInput("resources/input/time_series/" + INPUT_FILE);

		long endTransaltion = System.currentTimeMillis();

		System.out.println("Translated in " + (endTransaltion - startTranslation) + "ms");

		IAutomaton automate = new MinWidthPeak(translator.getTranslatedText().length());

		for (int i = 0; i < translator.getTranslatedText().length(); i++) {
			automate.applyNextInput(translator.getTranslatedText().charAt(i));
		}

		long endComputation = System.currentTimeMillis();

		System.out.println("Computed in " + (endComputation - endTransaltion) + "ms");

		System.out.println("Result : " + automate.getResult());

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
