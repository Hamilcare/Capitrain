package automaton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import alphabet.Alphabet;
import semantic.letter.impl.SemanticLetterFactory;
import states.StateFactory;
import transitions.ITransition;
import transitions.impl.Transition;

public class AutomatonBuilder {

	String pathToFile;
	final String separator = ",";

	public AutomatonBuilder(String pathToFile) {
		super();
		this.pathToFile = pathToFile;
	}

	void buildAutomaton() throws IOException {
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

	}

}
