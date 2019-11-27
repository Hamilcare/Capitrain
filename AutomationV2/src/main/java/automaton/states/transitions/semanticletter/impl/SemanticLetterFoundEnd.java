package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;
import automaton.states.transitions.semanticletter.AbstractSemanticLetter;

public class SemanticLetterFoundEnd extends AbstractSemanticLetter {

	public SemanticLetterFoundEnd(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		int bestValue = getAutomaton().getAccumulatorR().getCurrentValue();
		int currentMatchValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));

		if (bestValue == currentMatchValue) {

			int dStartXi = getAutomaton().getAccumulatorD().getStartXi();
			if (dStartXi != -1) {
				getAutomaton().getAccumulatorR().addStartXi(getAutomaton().getAccumulatorD().getStartXi());
			} else {
				getAutomaton().getAccumulatorR().addStartXi(getAutomaton().getCurrentXiPosition());
			}
			getAutomaton().getAccumulatorR().addEndXi(getAutomaton().getCurrentXiPosition());
		}

		else {
			int result = getAutomaton().getAggregator().apply(currentMatchValue, bestValue);
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

//		int tmpValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
//				getAutomaton().getFeature().getValue(0));
//		int newValue = getAutomaton().getAggregator().apply(getAutomaton().getAccumulatorR().getCurrentValue(),
//				tmpValue);
//
//		if (newValue != getAutomaton().getAccumulatorR().getCurrentValue()) {
//			getAutomaton().getAccumulatorR().updateValue(newValue);
//			int dStartXi = getAutomaton().getAccumulatorD().getStartXi();
//			if (dStartXi != -1) {
//				getAutomaton().getAccumulatorR().setStartXi(dStartXi);
//			} else {
//				getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getCurrentXiPosition());
//			}
//			getAutomaton().getAccumulatorR().setEndXi(getAutomaton().getCurrentXiPosition());
//		}

	}

	@Override
	public void updateAccC() {
		// NothingToDo
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
