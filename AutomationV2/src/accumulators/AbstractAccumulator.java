package accumulators;

import automaton.IAutomaton;

public abstract class AbstractAccumulator implements IAccumulator {

	IAutomaton automaton;
	int startXi;
	int endXi;
	int currentValue;

	static final int UNSET_POSITION = -1;

	public AbstractAccumulator(IAutomaton automaton) {
		this.automaton = automaton;
		startXi = UNSET_POSITION;
		endXi = UNSET_POSITION;
	}

	public IAutomaton getAutomaton() {
		return automaton;
	}

	@Override
	public int getCurrentValue() {
		return currentValue;
	}

	@Override
	public void updateValue(int newValue) {
		if (startXi == UNSET_POSITION) {
			startXi = automaton.getCurrentXiPosition();
		}
		if (endXi == UNSET_POSITION) {
			endXi = automaton.getCurrentXiPosition();
		}
		currentValue = newValue;
	}

}
