package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

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

//		int currCValue = getAutomaton().getAccumulatorC().getCurrentValue();
//		int currBestValue = getAutomaton().getAccumulatorR().getCurrentValue();
//
//		int newValue = getAutomaton().getAggregator().apply(currBestValue, currCValue);
//
//		if (newValue != getAutomaton().getAccumulatorR().getCurrentValue()) {
//			// La valeur trouvée est meilleure
//			getAutomaton().getAccumulatorR().setStartXi(getAutomaton().getAccumulatorC().getStartXi());
//			getAutomaton().getAccumulatorR().setEndXi(getAutomaton().getAccumulatorC().getEndXi());
//			getAutomaton().getAccumulatorR().updateValue(newValue);
//		} else if (currCValue == currBestValue) {
//			// Egalité
//		}

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
