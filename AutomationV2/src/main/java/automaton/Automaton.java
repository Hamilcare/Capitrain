package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import features.IFeature;
import states.IState;
import translation.ITranslator;

public class Automaton implements IAutomaton {

	public static final int UNDEFINED_GUARD = -1;

	IFeature feature;
	IAggregator aggregator;
	ITranslator translator;

	IAccumulator accumulatorD;
	IAccumulator accumulatorC;
	IAccumulator accumulatorR;

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
	public IAccumulator getAccumulatorD() {
		return accumulatorD;
	}

	@Override
	public IAccumulator getAccumulatorC() {
		return accumulatorC;
	}

	@Override
	public IAccumulator getAccumulatorR() {
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
	public AutomatonResult getResult() {
		int start;
		int end;

		int result = this.aggregator.apply(this.accumulatorR.getCurrentValue(), this.accumulatorC.getCurrentValue());
		if (result == this.accumulatorR.getCurrentValue()) {
			start = this.accumulatorR.getStartXi();
			end = this.accumulatorR.getEndXi();
		} else {
			start = this.accumulatorC.getStartXi();
			end = this.accumulatorC.getEndXi();
		}

		int value = this.aggregator.apply(this.accumulatorR.getCurrentValue(), this.accumulatorC.getCurrentValue());

		return new AutomatonResult(value, start, end);
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
	public void setAccumulators(IAccumulator d, IAccumulator c, IAccumulator r) {
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
