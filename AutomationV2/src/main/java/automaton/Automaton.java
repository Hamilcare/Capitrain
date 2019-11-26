package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import features.IFeature;
import states.IState;
import translation.ITranslator;

public class Automaton implements IAutomaton {

	public static final int UNDEFINEDGuard = -1;

	IFeature feature;
	IAggregator aggregator;
	ITranslator translator;

	IAccumulator ACCD;// = new AccumulatorD();
	IAccumulator ACCC;// = new AccumulatorC();
	IAccumulator ACCR;// = new AccumulatorR();

	int inputSequenceLength;
	IState currentState;
	int currentXiPosition = -1;

	int before;
	int after;

	int meilleurStart = UNDEFINEDGuard;
	int meilleurEnd = UNDEFINEDGuard;

	int bufferMeilleurStart = UNDEFINEDGuard;
	int bufferMeilleurEnd = UNDEFINEDGuard;

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
	public IAccumulator getAccumulatorD() { return ACCD; }

	@Override
	public IAccumulator getAccumulatorC() {
		return ACCC;
	}

	@Override
	public IAccumulator getAccumulatorR() {
		return ACCR;
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

		int result = this.aggregator.apply(this.ACCR.getCurrentValue(), this.ACCC.getCurrentValue());
		if (result == this.ACCR.getCurrentValue()) {
			start = this.ACCR.getStartXi();
			end = this.ACCR.getEndXi();
		} else {
			start = this.ACCC.getStartXi();
			end = this.ACCC.getEndXi();
		}

		int value = this.aggregator.apply(this.ACCR.getCurrentValue(), this.ACCC.getCurrentValue());

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
		this.ACCD = d;
		this.ACCC = c;
		this.ACCR = r;
	}

	@Override
	public void setBeforeAfter(int before, int after){
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
