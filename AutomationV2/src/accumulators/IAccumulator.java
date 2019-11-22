package accumulators;

import automaton.IAutomaton;

public interface IAccumulator {
	IAutomaton getAutomaton();

	void setToInitValue();

	int getCurrentValue();

	void updateValue(int newValue);

}
