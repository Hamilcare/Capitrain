package automaton.accumulators.tmp;

import automaton.accumulators.IAccumulator;

public interface IAccumulatorTemporaire extends IAccumulator {

	void setStartXi(int position);

	void setEndXi(int position);

	int getStartXi();

	int getEndXi();

}
