package automaton.states.transitions.semanticletter.impl;

import static automaton.accumulators.tmp.AbstractAccumulatorTemporaire.UNSET_POSITION;

import automaton.IAutomaton;

public class SemanticLetterFound0 extends SemanticLetterFound {

	public SemanticLetterFound0(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccC() {
		int tmpValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));
		int newValue = getAutomaton().getFeature().apply(tmpValue, getAutomaton().getFeature().getValue(1));

		getAutomaton().getAccumulatorC().updateValue(newValue);
		int startD = getAutomaton().getAccumulatorD().getStartXi();
		getAutomaton().getAccumulatorC()
				.setStartXi(startD == UNSET_POSITION ? getAutomaton().getCurrentXiPosition() : startD);
	}
}