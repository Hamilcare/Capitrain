package automaton;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import features.IFeature;

public interface IAutomaton {
	IFeature getFeature();

	IAggregator getAggregator();

	int getCurrentXiPosition();

	IAccumulator getAccumulatorD();

	IAccumulator getAccumulatorC();

	IAccumulator getAccumulatorR();

	int getInputSequenceLength();

}
