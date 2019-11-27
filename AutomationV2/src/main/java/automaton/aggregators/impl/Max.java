package automaton.aggregators.impl;

import automaton.aggregators.AbstractAggregator;
import automaton.features.IFeature;

public class Max extends AbstractAggregator {

	@Override
	public String getName() {
		return "MAX";
	}

	@Override
	public IFeature getFeature() {

		return getAutomaton().getFeature();
	}

	@Override
	public int getDefault() {
		return getFeature().getMin();
	}

	@Override
	public int apply(int a, int b) {
		return Math.max(a, b);
	}

}
