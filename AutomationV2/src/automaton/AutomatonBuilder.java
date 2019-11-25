package automaton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import accumulators.AccumulatorC;
import accumulators.AccumulatorD;
import accumulators.AccumulatorR;
import aggregators.IAggregator;
import alphabet.Alphabet;
import features.IFeature;
import semantic.letter.impl.SemanticLetterFactory;
import states.StateFactory;
import transitions.ITransition;
import transitions.impl.Transition;

public class AutomatonBuilder {

	String pathToFile;
	final String separator = ",";

	public AutomatonBuilder(String pathToFile, IFeature feature, IAggregator aggregator, BlockingQueue<Alphabet> bq) {
		super();
		Automaton.AUTOMATON.setFeature(feature);
		Automaton.AUTOMATON.setAggregator(aggregator);
		Automaton.AUTOMATON.setQueue(bq);
		this.pathToFile = pathToFile;
	}

	public void build() throws IOException {
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

	}

}
