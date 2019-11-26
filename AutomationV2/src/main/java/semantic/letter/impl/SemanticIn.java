package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticIn extends AbstractSemanticLetter {

	public SemanticIn(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// Nothing to do
	}

	@Override
	public void updateAccC() {
		int tmpRight = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue());

		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorC().getCurrentValue(), tmpRight);
		getAutomaton().getAccumulatorC().updateValue(newValue);

	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
