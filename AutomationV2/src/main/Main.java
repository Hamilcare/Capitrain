package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aggregators.impl.Sum;
import alphabet.Alphabet;
import automaton.Automaton;
import automaton.AutomatonBuilder;
import features.impl.Width;
import translation.ITranslator;
import translation.Translate;

public class Main {

	static String path = "./AutomationV2/input/peak.csv";

	static String input = "./BenchProgram/resources/input/1000000000.digt";
//	static String input = "input/exemple";
//	static String input = "input/exemple2";

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		long startTranslation = System.currentTimeMillis();
		ITranslator translator = translateInput(input);
		Automaton.AUTOMATON.setInputSequenceLenght(translator.getTextToTranslate().size());

		AutomatonBuilder builder = new AutomatonBuilder(path, new Width(), new Sum());
		builder.build();

//		System.out.println(translator.getTranslatedText());

		long endTransaltion = System.currentTimeMillis();

		System.out.println("Translation time : " + (endTransaltion - startTranslation));

//		System.out.println("Waiting input before computation");
//		sc.nextLine();

		long startComputation = System.currentTimeMillis();

		for (int i = 0; i < translator.getTranslatedText().length(); i++) {
			Automaton.AUTOMATON.applyNextInput(Alphabet.asEnum(translator.getTranslatedText().charAt(i)));
		}

		long endComputation = System.currentTimeMillis();

		System.out.println(Automaton.AUTOMATON.getResult());

		System.out.println("Automaton Time : " + (endComputation - endTransaltion));
		System.out.println("Total Time : " + (endComputation - startTranslation));
	}

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
