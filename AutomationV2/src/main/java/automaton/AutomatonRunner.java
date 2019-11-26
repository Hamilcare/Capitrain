package main.java.automaton;

import main.java.translation.ITranslator;

public class AutomatonRunner {
	private IAutomaton automaton;

	public AutomatonRunner(IAutomaton automaton) {
		this.automaton = automaton;
	}

	public Result run(ITranslator translator) {
		this.automaton.setInputSequenceLenght(translator.getInputSequenceLength());

		for (int i = 0; i < translator.getInputSequenceLength() - 1; i++) {
			this.automaton.applyNextInput(translator.getNextInput());
		}
		return new Result(this.automaton.getResult());
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
