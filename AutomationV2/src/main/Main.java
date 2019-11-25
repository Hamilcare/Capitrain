package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import aggregators.impl.Max;
import alphabet.Alphabet;
import automaton.Automaton;
import automaton.AutomatonBuilder;
import features.impl.Width;
import producer.impl.FileReaderProducer;
import translation.ITranslator;
import translation.Translate;

public class Main {

	static String path = "./input/peak.csv";

//	static String input = "./BenchProgram/resources/input/100000000.digt";
//	static String input = "input/exemple";
//	static String input = "input/exemple2";
	static String input = "input/10000000.digt";
	public static ITranslator translator;

	private static BlockingQueue<Alphabet> queue = new LinkedBlockingQueue<Alphabet>(Integer.MAX_VALUE);

	public static boolean producerIsAlive = true;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, InterruptedException {

//		System.out.println("Waiting input");
//		sc.nextLine();

		long startTranslation = System.currentTimeMillis();

		FileReaderProducer frp = new FileReaderProducer(queue, input);
		Thread producer = new Thread(frp);
		producer.run();

		AutomatonBuilder builder = new AutomatonBuilder(path, new Width(), new Max(), queue);
		builder.build();

		Thread consumer = new Thread(Automaton.AUTOMATON);
		consumer.run();

		producer.join();

		consumer.join();

		long endTransaltion = System.currentTimeMillis();
		System.out.println(Automaton.AUTOMATON.getResult());

		System.out.println("Elapsed time : " + (endTransaltion - startTranslation));

//		long startTranslation = System.currentTimeMillis();
//		translator = translateInput(input);
//
//		AutomatonBuilder builder = new AutomatonBuilder(path, new Max(), new Min());
//		builder.build();
//
////		System.out.println(translator.getTranslatedText());
//
//		long endTransaltion = System.currentTimeMillis();
//
//		System.out.println("Translation time : " + (endTransaltion - startTranslation));
//
////		System.out.println("Waiting input before computation");
////		sc.nextLine();
//
//		long startComputation = System.currentTimeMillis();
//
//		for (int i = 0; i < translator.getTranslatedText().length(); i++) {
//			Automaton.AUTOMATON.applyNextInput(Alphabet.asEnum(translator.getTranslatedText().charAt(i)));
//		}
//
//		long endComputation = System.currentTimeMillis();
//
//		System.out.println(Automaton.AUTOMATON.getResult());
//
//		System.out.println("Automaton Time : " + (endComputation - endTransaltion));
//		System.out.println("Total Time : " + (endComputation - startTranslation));
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
