package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticIn0 extends SemanticIn {

	public SemanticIn0(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccC() {
		int tmpRight = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(1));

		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorC().getCurrentValue(), tmpRight);
		getAutomaton().getAccumulatorC().updateValue(newValue);

	}
}