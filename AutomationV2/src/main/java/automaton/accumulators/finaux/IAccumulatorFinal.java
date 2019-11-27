package automaton.accumulators.finaux;

import java.util.List;

import automaton.accumulators.IAccumulator;

public interface IAccumulatorFinal extends IAccumulator {

	void addStartXi(int position);

	void addEndXi(int position);

	List<Integer> getStartXi();

	List<Integer> getEndXi();
}
