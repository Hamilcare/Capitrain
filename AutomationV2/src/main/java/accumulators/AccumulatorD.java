package main.java.accumulators;

public class AccumulatorD extends AbstractAccumulator {

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
