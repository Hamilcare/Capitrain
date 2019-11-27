package application;

import java.io.IOException;
import java.util.List;

import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
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
		System.out.println(cliParser.getTranslator().getInputSequenceLength());
		long endTransaltion = System.currentTimeMillis();
		System.out.println("Translation time : " + (endTransaltion - startTranslation) + " ms");

		long startComputation = System.currentTimeMillis();

		IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(cliParser.getPatternFilePath(),
				cliParser.getFeature(), cliParser.getAggregator(), cliParser.getTranslator());

		AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
		List<AutomatonResult> result = automatonRunner.run();

		long endComputation = System.currentTimeMillis();

//		System.out.println(String.format("Result: %s, [%s,%s]", result.getValue(), result.getX1(), result.getX2()));


		System.out.println("Automaton Time : " + (endComputation - startComputation) + " ms");
		System.out.println("Total Time : " + (endComputation - startTranslation) + " ms");

		//Print nb result
		System.out.println(result.size() + " matches");
		//Print each result
		result.stream().forEach(res ->
			System.out.println(String.format("Value : %s, startXi : %s, endXi : %s", res.getValue(), res.getX1(), res.getX2()))
		);
	}
}
