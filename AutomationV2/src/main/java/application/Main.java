package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
import translation.ITranslator;
import translation.Translate;
import utils.CliParser;
import utils.CliParserException;

public class Main {

	public static void main(String[] args) throws IOException, CliParserException {

		long startTranslation = System.currentTimeMillis();
		CliParser cliParser = new CliParser(args);
		cliParser.parse();

		System.out.println(String.format("Starting with: %s %s %s", cliParser.getAggregator().getName(), cliParser.getFeature().getName(), cliParser.getPatternFilePath()));
		System.out.println(String.format("Data file: %s", cliParser.getDataFilePath()));
		ITranslator translator = translateInput(cliParser.getDataFilePath());
		long endTranslation = System.currentTimeMillis();
		System.out.println("Translation time : " + (endTranslation - startTranslation));

		long startComputation = System.currentTimeMillis();

		IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(cliParser.getPatternFilePath(), cliParser.getFeature(), cliParser.getAggregator(), translator);
		AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
		AutomatonResult result = automatonRunner.run();


		long endComputation = System.currentTimeMillis();

		System.out.println(String.format("Result: %s, [%s,%s]", result.getValue(), result.getX1(), result.getX2()));

		System.out.println("Automaton Time : " + (endComputation - startComputation));
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
