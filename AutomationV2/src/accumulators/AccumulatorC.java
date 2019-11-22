package accumulators;

public class AccumulatorC extends AbstractAccumulator {

	@Override
	public void setToInitValue() {
		this.currentValue = automaton.getAggregator().getDefault();
	}

}
