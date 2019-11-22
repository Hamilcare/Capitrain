package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import features.IFeature;
import states.IState;

public class Automaton implements IAutomaton {

	public static final Automaton AUTOMATON = new Automaton();
	IFeature feature;
	IAggregator aggregator;

	IAccumulator ACCD;// = new AccumulatorD();
	IAccumulator ACCC;// = new AccumulatorC();
	IAccumulator ACCR;// = new AccumulatorR();
	int inputSequenceLength;
	IState currentState;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IAccumulator getAccumulatorD() {

		return ACCD;
	}

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

		AUTOMATON.currentState = newState;
//		System.out.print(AUTOMATON.currentState.getLabel());

	}

	@Override
	public void setInputSequenceLenght(int lenght) {
		AUTOMATON.inputSequenceLength = lenght;
	}

	@Override
	public void setFeature(IFeature f) {
		AUTOMATON.feature = f;
	}

	@Override
	public void setAggregator(IAggregator a) {
		AUTOMATON.aggregator = a;
	}

	@Override
	public int getResult() {
		return AUTOMATON.aggregator.apply(AUTOMATON.ACCR.getCurrentValue(), AUTOMATON.ACCC.getCurrentValue());
	}

}
