package accumulators;

import automaton.IAutomaton;

public class DAccumulator extends AbstractAccumulator {

	public DAccumulator(IAutomaton automaton) {
		super(automaton);
		this.currentValue = this.getAutomaton().getFeature().getNeutral();
	}

	@Override
	public IAutomaton getAutomaton() {
		return this.automaton;
	}

	@Override
	public void setToInitValue() {
		this.startXi = UNSET_POSITION;
		this.endXi = UNSET_POSITION;
		this.currentValue = getAutomaton().getFeature().getNeutral();
	}

}
