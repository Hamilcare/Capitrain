package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import alphabet.Alphabet;
import features.IFeature;
import states.IState;
import translation.ITranslator;

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

	void setAccumulators(IAccumulator d, IAccumulator c, IAccumulator r);

	void setBeforeAfter(int before, int after);
	int getBefore();
	int getAfter();
}
