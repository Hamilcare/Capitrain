package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import features.IFeature;
import states.IState;

public class Automaton implements IAutomaton {

	public static final IAutomaton AUTOMATON = new Automaton();

	@Override
	public IFeature getFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAggregator getAggregator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrentXiPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IAccumulator getAccumulatorD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAccumulator getAccumulatorC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAccumulator getAccumulatorR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInputSequenceLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IState getCurrentState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentState(IState newState) {
		// TODO Auto-generated method stub

	}

}
