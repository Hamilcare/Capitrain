package states;

import alphabets.InputAlphabet;

public final class StateD extends AbstractState {

	static final String label = "d";

	@Override
	public IState applyTransitions(char input) {
		if (input == (InputAlphabet.LESS)) {
			return new StateR();
		} else {
			return new StateD();
		}
	}

	@Override
	public String getLabel() {
		return label;
	}
}
