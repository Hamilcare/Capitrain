package automaton.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import automaton.IAutomaton;
import automaton.accumulators.finaux.AccumulatorR;
import automaton.accumulators.tmp.AccumulatorC;
import automaton.accumulators.tmp.AccumulatorD;
import automaton.aggregators.IAggregator;
import alphabet.Alphabet;
import automaton.features.IFeature;
import automaton.states.transitions.semanticletter.impl.SemanticLetterFactory;
import automaton.states.StateFactory;
import automaton.states.transitions.ITransition;
import automaton.states.transitions.impl.Transition;
import translation.ITranslator;

public class AutomatonBuilder {

	private AutomatonBuilder() {
		// Sonar
	}

	private static final String SEPARATOR = ",";

	public static IAutomaton buildNewAutomaton(String pathToFile, IFeature feature, IAggregator aggregator,
											   ITranslator translator) throws IOException {
		IAutomaton automaton = new Automaton();

		feature.setAutomaton(automaton);
		automaton.setFeature(feature);

		aggregator.setAutomaton(automaton);
		automaton.setAggregator(aggregator);

		automaton.setTranslator(translator);

		automaton.setInputSequenceLenght(translator.getInputSequenceLength());

		List<String> fileContent = Files.readAllLines(Paths.get(pathToFile));
		String[] beforeAfter = fileContent.get(0).split(SEPARATOR);
		int before = Integer.parseInt(beforeAfter[0]);
		int after = Integer.parseInt(beforeAfter[1]);
		automaton.setBeforeAfter(before, after);

		String[] states = fileContent.get(1).split(SEPARATOR);
		String startLabel = states[0];

		for (String stateLabel : states) {
			StateFactory.builStateWithLabler(stateLabel);
		}

		for (int i = 2; i < fileContent.size(); i++) {
			String[] transitionParams = fileContent.get(i).split(SEPARATOR);

			ITransition newTransition = new Transition(Alphabet.asEnum(transitionParams[0]),
					SemanticLetterFactory.getSemantic(transitionParams[1], automaton, after),
					StateFactory.getStateFromLabel(transitionParams[3]));
			StateFactory.getStateFromLabel(transitionParams[2]).addTransition(newTransition);
		}

		automaton.setCurrentState(StateFactory.getStateFromLabel(startLabel));

		automaton.setAccumulators(new AccumulatorD(automaton), new AccumulatorC(automaton),
				new AccumulatorR(automaton));

		return automaton;
	}
}
