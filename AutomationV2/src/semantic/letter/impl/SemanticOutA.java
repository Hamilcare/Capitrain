package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticOutA extends AbstractSemanticLetter {

	public SemanticOutA(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		int newValue = getAutomaton().getAggregator().apply(getAutomaton().getAccumulatorR().getCurrentValue(),
				getAutomaton().getAccumulatorC().getCurrentValue());

		getAutomaton().getAccumulatorR().updateValue(newValue);
	}

	@Override
	public void updateAccC() {
		getAutomaton().getAccumulatorC().setToInitValue();
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
