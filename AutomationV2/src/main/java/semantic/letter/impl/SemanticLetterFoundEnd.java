package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticLetterFoundEnd extends AbstractSemanticLetter {

	public SemanticLetterFoundEnd(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		int tmpValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue());
		int newValue = getAutomaton().getAggregator().apply(getAutomaton().getAccumulatorR().getCurrentValue(),
				tmpValue);

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

	@Override
	public void updateAccC() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
