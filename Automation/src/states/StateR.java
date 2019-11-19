package states;

import alphabets.InputAlphabet;

public class StateR extends AbstractState {

	static final String label = "r";

	@Override
	public IState applyTransitions(char input) {
		if (input == InputAlphabet.LESS) {
			automaton.setD(automaton.getD() + 1);
			return new StateR();
		}

		if (input == InputAlphabet.EQUALS) {
			automaton.setD(automaton.getD() + 1);
			return new StateR();
		}

		if (input == InputAlphabet.MORE) {
			automaton.setC(automaton.getD() + 1);
			automaton.setD(0);
			return new StateT();
		}

		return null;

	}

	@Override
	public String getLabel() {
		return label;
	}

}
