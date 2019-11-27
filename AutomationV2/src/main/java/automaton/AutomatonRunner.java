package automaton;

import java.util.List;

public class AutomatonRunner {
	private IAutomaton automaton;

	public AutomatonRunner(IAutomaton automaton) {
		this.automaton = automaton;
	}

	public List<AutomatonResult> run() {
		this.automaton.setInputSequenceLenght(automaton.getInputSequenceLength());

		for (int i = 0; i < automaton.getInputSequenceLength() - 1; i++) {

			this.automaton.applyNextInput(automaton.getTranslator().getNextInput());
		}
		return this.automaton.getResult();
	}

}
