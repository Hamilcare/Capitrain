package accumulators;

import automaton.IAutomaton;

public interface IAccumulator {

	public static final int UNSET_POSITION = -1;

	void updateValue(int newValue);

	IAutomaton getAutomaton();

	void setToInitValue();

	int getCurrentValue();

	void setStartXi(int position);

	void setEndXi(int position);

}
