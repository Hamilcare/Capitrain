package semantic.letter.impl;

import static accumulators.AbstractAccumulator.UNSET_POSITION;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

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
				getAutomaton().getFeature().getValue(0));
		getAutomaton().getAccumulatorC().updateValue(newValue);
		int startD = getAutomaton().getAccumulatorD().getStartXi();
		getAutomaton().getAccumulatorC()
				.setStartXi(startD == UNSET_POSITION ? getAutomaton().getCurrentXiPosition() : startD);
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
