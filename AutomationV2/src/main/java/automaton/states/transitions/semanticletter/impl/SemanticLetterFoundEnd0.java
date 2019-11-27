package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;

public class SemanticLetterFoundEnd0 extends SemanticLetterFoundEnd {

	public SemanticLetterFoundEnd0(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {

		int bestValue = getAutomaton().getAccumulatorR().getCurrentValue();

		int innerValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));
		int currentMatchValue = getAutomaton().getFeature().apply(innerValue, getAutomaton().getFeature().getValue(1));

		if (bestValue == currentMatchValue) {
			int dStartXi = getAutomaton().getAccumulatorD().getStartXi();
			if (dStartXi != -1) {
				getAutomaton().getAccumulatorR().addStartXi(getAutomaton().getAccumulatorD().getStartXi());
			} else {
				getAutomaton().getAccumulatorR().addStartXi(getAutomaton().getCurrentXiPosition());
			}
			getAutomaton().getAccumulatorR().addEndXi(getAutomaton().getCurrentXiPosition());
		} else {
			int result = getAutomaton().getAggregator().apply(bestValue, currentMatchValue);
			if (result != bestValue) {
				getAutomaton().getAccumulatorR().updateValue(result);

				int dStartXi = getAutomaton().getAccumulatorD().getStartXi();
				if (dStartXi != -1) {
					getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getAccumulatorD().getStartXi());
				} else {
					getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getCurrentXiPosition());
				}
				getAutomaton().getAccumulatorR().setEndXi(getAutomaton().getCurrentXiPosition());

			}
		}

	}

}
