package automaton;

public class AutomatonRunner {
	private IAutomaton automaton;

	public AutomatonRunner(IAutomaton automaton) {
		this.automaton = automaton;
	}

	public AutomatonResult run() {
		this.automaton.setInputSequenceLenght(automaton.getInputSequenceLength());

		for (int i = 0; i < automaton.getInputSequenceLength() - 1; i++) {
			this.automaton.applyNextInput(automaton.getTranslator().getNextInput());
		}
		return this.automaton.getResult();
	}

	public class Result {
		private Result(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		private int value;
	}

}
