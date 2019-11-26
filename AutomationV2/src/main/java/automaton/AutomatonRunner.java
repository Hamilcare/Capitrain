package automaton;

public class AutomatonRunner {
	private IAutomaton automaton;
	long start;
	long end;

	public AutomatonRunner(IAutomaton automaton) {
		this.automaton = automaton;
	}

	public AutomatonResult run() {
		this.automaton.setInputSequenceLenght(automaton.getInputSequenceLength());
		start = System.currentTimeMillis();
		for (int i = 0; i < automaton.getInputSequenceLength() - 1; i++) {
			if (i % 10000 == 0) {
				end = System.currentTimeMillis();
				System.out.println(i + "en " + (end - start) + "ms");
				start = System.currentTimeMillis();
			}
			this.automaton.applyNextInput(automaton.getTranslator().getNextInput());
		}
		return this.automaton.getResult();
	}

}
