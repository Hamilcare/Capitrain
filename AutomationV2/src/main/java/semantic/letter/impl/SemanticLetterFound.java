package main.java.semantic.letter.impl;

import main.java.automaton.IAutomaton;
import main.java.semantic.letter.AbstractSemanticLetter;

public class SemanticLetterFound extends AbstractSemanticLetter {

	public SemanticLetterFound(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// Nothing to do
	}

	@Override
	public void updateAccC() {
		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue());
		getAutomaton().getAccumulatorC().updateValue(newValue);
		getAutomaton().getAccumulatorC().setStartXi(getAutomaton().getAccumulatorD().getStartXi());
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
