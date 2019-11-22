package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticMaybeB extends AbstractSemanticLetter {

	public SemanticMaybeB(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// Nothing to do
	}

	@Override
	public void updateAccC() {
		// Nothing to do
	}

	@Override
	public void updateAccD() {
		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue());
		getAutomaton().getAccumulatorD().updateValue(newValue);
	}

}