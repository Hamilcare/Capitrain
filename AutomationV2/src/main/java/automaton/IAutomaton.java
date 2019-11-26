package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import alphabet.Alphabet;
import features.IFeature;
import states.IState;

public interface IAutomaton {
	IFeature getFeature();

	IAggregator getAggregator();

	int getCurrentXiPosition();

	IAccumulator getAccumulatorD();

	IAccumulator getAccumulatorC();

	IAccumulator getAccumulatorR();

	int getInputSequenceLength();

	void setInputSequenceLenght(int length);

	IState getCurrentState();

	void setCurrentState(IState newState);

	void setFeature(IFeature f);

	void setAggregator(IAggregator a);

	default void applyNextInput(Alphabet nextInput) {
		IState newState = getCurrentState().applyTransition(nextInput);
		setCurrentState(newState);
	}

	int getResult();

}