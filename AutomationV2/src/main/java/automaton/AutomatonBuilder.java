package main.java.automaton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.java.accumulators.AccumulatorC;
import main.java.accumulators.AccumulatorD;
import main.java.accumulators.AccumulatorR;
import main.java.aggregators.IAggregator;
import main.java.alphabet.Alphabet;
import main.java.features.IFeature;
import main.java.semantic.letter.impl.SemanticLetterFactory;
import main.java.states.StateFactory;
import main.java.transitions.ITransition;
import main.java.transitions.impl.Transition;
import main.java.translation.ITranslator;

public class AutomatonBuilder {

	private final static String separator = ",";

	public static IAutomaton buildNewAutomaton(String pathToFile, IFeature feature, IAggregator aggregator,
			ITranslator translator) throws IOException {
		Automaton.AUTOMATON.setFeature(feature);
		Automaton.AUTOMATON.setAggregator(aggregator);
		Automaton.AUTOMATON.setTranslator(translator);
		Automaton.AUTOMATON.setInputSequenceLenght(translator.getInputSequenceLength());

		List<String> fileContent = Files.readAllLines(Paths.get(pathToFile));
		String[] states = fileContent.get(0).split(separator);

		String startLabel = states[0];

		for (String stateLabel : states) {
			StateFactory.builStateWithLabler(stateLabel);
		}

		for (int i = 1; i < fileContent.size(); i++) {
			String[] transitionParams = fileContent.get(i).split(separator);

			ITransition newTransition = new Transition(Alphabet.asEnum(transitionParams[0]),
					SemanticLetterFactory.getSemantic(transitionParams[1]),
					StateFactory.getStateFromLabel(transitionParams[3]));

			StateFactory.getStateFromLabel(transitionParams[2]).addTransition(newTransition);
		}

		Automaton.AUTOMATON.setCurrentState(StateFactory.getStateFromLabel(startLabel));

		Automaton.AUTOMATON.ACCC = new AccumulatorC();
		Automaton.AUTOMATON.ACCD = new AccumulatorD();
		Automaton.AUTOMATON.ACCR = new AccumulatorR();

		return Automaton.AUTOMATON;
	}
}
