package semantic.letter.impl;

import automaton.IAutomaton;

public class SemanticMaybeA0 extends SemanticMaybeA {

	public SemanticMaybeA0(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccD() {
		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(1));
		getAutomaton().getAccumulatorD().updateValue(newValue);
	}

}
