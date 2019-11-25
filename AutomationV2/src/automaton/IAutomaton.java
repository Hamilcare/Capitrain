package automaton;

import java.util.concurrent.BlockingQueue;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import alphabet.Alphabet;
import features.IFeature;
import states.IState;

public interface IAutomaton extends Runnable {
	IFeature getFeature();

	IAggregator getAggregator();

	int getCurrentXiPosition();

	IAccumulator getAccumulatorD();

	IAccumulator getAccumulatorC();

	IAccumulator getAccumulatorR();

	IState getCurrentState();

	void setCurrentState(IState newState);

	void setFeature(IFeature f);

	void setAggregator(IAggregator a);

	void setQueue(BlockingQueue<Alphabet> q);

	default void applyNextInput(Alphabet nextInput) {
		IState newState = getCurrentState().applyTransition(nextInput);
		setCurrentState(newState);
	}

	int getResult();

}
