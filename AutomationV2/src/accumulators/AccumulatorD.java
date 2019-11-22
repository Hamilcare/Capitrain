package accumulators;

public class AccumulatorD extends AbstractAccumulator {

	@Override
	public void setToInitValue() {
		this.currentValue = getAutomaton().getFeature().getNeutral();
	}

}
