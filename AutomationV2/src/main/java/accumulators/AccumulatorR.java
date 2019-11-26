package accumulators;

import automaton.IAutomaton;

public class AccumulatorR extends AbstractAccumulator {
	public AccumulatorR(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void setToInitValue() {
		this.currentValue = automaton.getAggregator().getDefault();
	}
}
