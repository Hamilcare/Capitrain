package accumulators.tmp;

import automaton.IAutomaton;

public class AccumulatorC extends AbstractAccumulatorTemporaire {

	public AccumulatorC(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void setToInitValue() {
		this.currentValue = automaton.getAggregator().getDefault();
		this.startXi = UNSET_POSITION;
		this.endXi = UNSET_POSITION;
	}

	@Override
	public void updateValue(int newValue) {
		if (startXi == UNSET_POSITION) {
			startXi = automaton.getCurrentXiPosition();
		}
		if (startXi != UNSET_POSITION) {
			endXi = automaton.getCurrentXiPosition();
		}
		currentValue = newValue;
	}

}
