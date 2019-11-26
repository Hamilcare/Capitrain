package main.java.accumulators;

import main.java.automaton.IAutomaton;

public interface IAccumulator {
	IAutomaton getAutomaton();

	void setToInitValue();

	int getCurrentValue();

	void updateValue(int newValue);

	void setStartXi(int position);

	void setEndXi(int position);

	int getStartXi();

	int getEndXi();

}
