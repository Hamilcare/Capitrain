package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;
import automaton.states.transitions.semanticletter.AbstractSemanticLetter;

public class SemanticOutA extends AbstractSemanticLetter {

	public SemanticOutA(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		int bestValue = getAutomaton().getAccumulatorR().getCurrentValue();
		int currentMatchValue = getAutomaton().getAccumulatorC().getCurrentValue();
		if (bestValue == currentMatchValue) {
			getAutomaton().getAccumulatorR().addStartXi(getAutomaton().getAccumulatorC().getStartXi());
			getAutomaton().getAccumulatorR().addEndXi(getAutomaton().getAccumulatorC().getEndXi());
		}

		else {
			int result = getAutomaton().getAggregator().apply(currentMatchValue, bestValue);
			if (result != bestValue) {
				getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getAccumulatorC().getStartXi());
				getAutomaton().getAccumulatorR().setEndXi(getAutomaton().getAccumulatorC().getEndXi());
				getAutomaton().getAccumulatorR().updateValue(result);
			}
		}

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
