package semantic.letter.impl;

import automaton.IAutomaton;
import features.IFeature;
import semantic.letter.AbstractSemanticLetter;

public class SemanticLetterFoundEnd0 extends SemanticLetterFound {

	public SemanticLetterFoundEnd0(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		int innerValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));
		int rightValue = getAutomaton().getFeature().apply(innerValue, getAutomaton().getFeature().getValue(1));

		int newValue = getAutomaton().getAggregator().apply(getAutomaton().getAccumulatorR().getCurrentValue(), rightValue);

		if (newValue != getAutomaton().getAccumulatorR().getCurrentValue()) {
			getAutomaton().getAccumulatorR().updateValue(newValue);
			int dStartXi = getAutomaton().getAccumulatorD().getStartXi();
			if (dStartXi != -1) {
				getAutomaton().getAccumulatorR().setStartXi(dStartXi);
			} else {
				getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getCurrentXiPosition());
			}
			getAutomaton().getAccumulatorR().setEndXi(getAutomaton().getCurrentXiPosition());
		}

	}



}
