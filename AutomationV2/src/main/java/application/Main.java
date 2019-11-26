package application;

import java.io.IOException;

import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;
import utils.CliParser;
import utils.CliParserException;

public class Main {

	public static void main(String[] args) throws IOException, CliParserException {

		long startTranslation = System.currentTimeMillis();
		CliParser cliParser = new CliParser(args);
		cliParser.parse();

		System.out.println(String.format("Starting with: %s %s %s", cliParser.getAggregator().getName(),
				cliParser.getFeature().getName(), cliParser.getPatternFilePath()));
		System.out.println(String.format("Data file: %s", cliParser.getDataFilePath()));
//		translator = translateInput(cliParser.getDataFilePath());

		ITranslator translator = new OneLineFileTranslator(cliParser.getDataFilePath());

		long endTransaltion = System.currentTimeMillis();
		System.out.println("Translation time : " + (endTransaltion - startTranslation));

		long startComputation = System.currentTimeMillis();

		IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(cliParser.getPatternFilePath(),
				cliParser.getFeature(), cliParser.getAggregator(), translator);

		AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
		AutomatonResult result = automatonRunner.run();

		long endComputation = System.currentTimeMillis();

		System.out.println(String.format("Result: %s, [%s,%s]", result.getValue(), result.getX1(), result.getX2()));

		System.out.println("Automaton Time : " + (endComputation - startComputation));
		System.out.println("Total Time : " + (endComputation - startTranslation));
	}
}
