package main.java.application;

import java.io.IOException;
import java.util.Scanner;

import main.java.automaton.AutomatonBuilder;
import main.java.automaton.AutomatonRunner;
import main.java.automaton.IAutomaton;
import main.java.translation.ITranslator;
import main.java.translation.impl.OneLineFileTranslator;
import main.java.utils.CliParser;
import main.java.utils.CliParserException;

public class Main {

	public static ITranslator translator;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, CliParserException {

		long startTranslation = System.currentTimeMillis();
		CliParser cliParser = new CliParser(args);
		cliParser.parse();

		System.out.println(String.format("Starting with: %s %s %s", cliParser.getAggregatorName(),
				cliParser.getFeatureName(), cliParser.getPatternFilePath()));
		System.out.println(String.format("Data file: %s", cliParser.getDataFilePath()));
//		translator = translateInput(cliParser.getDataFilePath());

		translator = new OneLineFileTranslator(cliParser.getDataFilePath());

		long endTransaltion = System.currentTimeMillis();
		System.out.println("Translation time : " + (endTransaltion - startTranslation));

		long startComputation = System.currentTimeMillis();

		IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(cliParser.getPatternFilePath(),
				cliParser.getFeature(), cliParser.getAggregator(), translator);
		AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
		AutomatonRunner.Result result = automatonRunner.run(translator);

		long endComputation = System.currentTimeMillis();

		System.out.println("Result: " + result.getValue());

		System.out.println("Automaton Time : " + (endComputation - startComputation));
		System.out.println("Total Time : " + (endComputation - startTranslation));
	}

//	public static ITranslator translateInput(String pathToData) {
//		try {
//			String content = new String(Files.readAllBytes(Paths.get(pathToData)));
//			System.out.println("Text contains " + content.length() + " characters");
//
//			List<Integer> textToTranslate = new ArrayList<>(content.length());
//			for (int i = 0; i < content.length(); i++) {
//				textToTranslate.add(Character.getNumericValue(content.charAt(i)));
//			}
//
//			System.out.println("size array : " + textToTranslate.size());
//			ITranslator translator = new Translate(textToTranslate);
//			translator.translate();
//			System.out.println("Translated");
//
//			return translator;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
