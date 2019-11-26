package accumulators;

import automaton.IAutomaton;

public abstract class AbstractAccumulator implements IAccumulator {

	IAutomaton automaton;
	int startXi;
	int endXi;
	int currentValue;

	public static final int UNSET_POSITION = -1;

	public AbstractAccumulator(IAutomaton automaton) {
		this.automaton = automaton;
		startXi = UNSET_POSITION;
		endXi = UNSET_POSITION;
		this.setToInitValue();
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

	@Override
	public void setStartXi(int position) {
		this.startXi = position;
	}

	@Override
	public void setEndXi(int position) {
		this.endXi = position;
	}

	@Override
	public int getStartXi() {
		return startXi;
	}

	@Override
	public int getEndXi() {
		return endXi;
	}

}
