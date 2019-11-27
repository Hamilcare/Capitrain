package automaton;

import java.util.List;

import automaton.accumulators.finaux.IAccumulatorFinal;
import automaton.accumulators.tmp.IAccumulatorTemporaire;
import automaton.aggregators.IAggregator;
import alphabet.Alphabet;
import automaton.features.IFeature;
import automaton.impl.AutomatonResult;
import automaton.states.IState;
import translation.ITranslator;

public interface IAutomaton {
	IFeature getFeature();

	IAggregator getAggregator();

	int getCurrentXiPosition();

	IAccumulatorTemporaire getAccumulatorD();

	IAccumulatorTemporaire getAccumulatorC();

	IAccumulatorFinal getAccumulatorR();

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

	List<AutomatonResult> getResult();

	void setTranslator(ITranslator translator);

	ITranslator getTranslator();

	void setAccumulators(IAccumulatorTemporaire d, IAccumulatorTemporaire c, IAccumulatorFinal r);

	void setBeforeAfter(int before, int after);

	int getBefore();

	int getAfter();
}
