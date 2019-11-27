package accumulators.tmp;

import automaton.IAutomaton;

public class AccumulatorD extends AbstractAccumulatorTemporaire {

	public AccumulatorD(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void setToInitValue() {
		this.currentValue = getAutomaton().getFeature().getNeutral();
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
