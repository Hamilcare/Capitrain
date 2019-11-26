package main.java.automaton;

import main.java.accumulators.IAccumulator;
import main.java.aggregators.IAggregator;
import main.java.alphabet.Alphabet;
import main.java.features.IFeature;
import main.java.states.IState;
import main.java.translation.ITranslator;

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

	AutomatonResult getResult();

	void setTranslator(ITranslator translator);

	ITranslator getTranslator();

}
