package accumulators;

public class AccumulatorR extends AbstractAccumulator {
	@Override
	public void setToInitValue() {
		this.currentValue = automaton.getAggregator().getDefault();
	}
}
