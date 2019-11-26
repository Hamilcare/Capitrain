package accumulators;

public class AccumulatorC extends AbstractAccumulator {

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
