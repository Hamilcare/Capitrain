package states;

import alphabets.InputAlphabet;

public class StateT extends AbstractState {

	static final String label = "t";

	@Override
	public IState applyTransitions(char input) {

		if (input == InputAlphabet.LESS) {
			automaton.setR(Math.min(automaton.getR(), automaton.getC()));
			automaton.setC(automaton.getSerieSize());
			automaton.setD(0);
			return new StateR();
		}

		if (input == InputAlphabet.EQUALS) {
			automaton.setD(automaton.getD() + 1);
			return new StateT();
		}

		if (input == InputAlphabet.MORE) {
			automaton.setC(automaton.getC() + automaton.getD() + 1);
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
