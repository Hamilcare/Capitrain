package automaton.impl;

import java.util.ArrayList;
import java.util.List;

import automaton.IAutomaton;
import automaton.accumulators.finaux.IAccumulatorFinal;
import automaton.accumulators.tmp.IAccumulatorTemporaire;
import automaton.aggregators.IAggregator;
import automaton.features.IFeature;
import automaton.states.IState;
import translation.ITranslator;

public class Automaton implements IAutomaton {

	public static final int UNDEFINED_GUARD = -1;

	IFeature feature;
	IAggregator aggregator;
	ITranslator translator;

	IAccumulatorTemporaire accumulatorD;
	IAccumulatorTemporaire accumulatorC;
	IAccumulatorFinal accumulatorR;

	int inputSequenceLength;
	IState currentState;
	int currentXiPosition = -1;

	int before;
	int after;

	@Override
	public IFeature getFeature() {
		return feature;
	}

	@Override
	public IAggregator getAggregator() {
		return aggregator;
	}

	@Override
	public int getCurrentXiPosition() {
		return this.currentXiPosition;
	}

	@Override
	public IAccumulatorTemporaire getAccumulatorD() {
		return accumulatorD;
	}

	@Override
	public IAccumulatorTemporaire getAccumulatorC() {
		return accumulatorC;
	}

	@Override
	public IAccumulatorFinal getAccumulatorR() {
		return accumulatorR;
	}

	@Override
	public int getInputSequenceLength() {
		return inputSequenceLength;
	}

	@Override
	public IState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(IState newState) {
		this.currentState = newState;
		this.currentXiPosition++;
	}

	@Override
	public void setInputSequenceLenght(int lenght) {
		this.inputSequenceLength = lenght;
	}

	@Override
	public void setFeature(IFeature f) {
		this.feature = f;
	}

	@Override
	public void setAggregator(IAggregator a) {
		this.aggregator = a;
	}

	@Override
	public List<AutomatonResult> getResult() {

		int bestValue = getAccumulatorR().getCurrentValue();
		int currentMatchValue = getAccumulatorC().getCurrentValue();
		if (bestValue == currentMatchValue) {
			getAccumulatorR().addStartXi(getAccumulatorC().getStartXi());
			getAccumulatorR().addEndXi(getAccumulatorC().getEndXi());
		}

		else {
			int result = getAggregator().apply(currentMatchValue, bestValue);
			if (result != bestValue) {
				bestValue = result;
				getAccumulatorR().setStartXi(getAccumulatorC().getStartXi());
				getAccumulatorR().setEndXi(getAccumulatorC().getEndXi());
				getAccumulatorR().updateValue(result);
			}
		}

		int nbResult = getAccumulatorR().getStartXi().size();
		List<AutomatonResult> lstResult = new ArrayList<>(nbResult);

		for (int i = 0; i < nbResult; i++) {
			lstResult.add(new AutomatonResult(bestValue, getAccumulatorR().getStartXi().get(i),
					getAccumulatorR().getEndXi().get(i)));
		}

		return lstResult;
	}

	@Override
	public ITranslator getTranslator() {
		return this.translator;
	}

	@Override
	public void setTranslator(ITranslator translator) {
		this.translator = translator;
	}

	@Override
	public void setAccumulators(IAccumulatorTemporaire d, IAccumulatorTemporaire c, IAccumulatorFinal r) {
		this.accumulatorD = d;
		this.accumulatorC = c;
		this.accumulatorR = r;
	}

	@Override
	public void setBeforeAfter(int before, int after) {
		this.before = before;
		this.after = after;
	}

	public int getBefore() {
		return before;
	}

	public int getAfter() {
		return after;
	}

}
