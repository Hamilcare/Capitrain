package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

public class SemanticLetterFound0 extends SemanticLetterFound {

	public SemanticLetterFound0(IAutomaton automaton) {
		super(automaton);
	}


	@Override
	public void updateAccC() {
		int tmpValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));
		int newValue= getAutomaton().getFeature().apply(tmpValue, getAutomaton().getFeature().getValue(1));

		getAutomaton().getAccumulatorC().updateValue(newValue);
		getAutomaton().getAccumulatorC().setStartXi(getAutomaton().getAccumulatorD().getStartXi());
	}
}
