package automaton.aggregators.impl;

import automaton.aggregators.AbstractAggregator;
import automaton.features.IFeature;

public class Min extends AbstractAggregator {

	@Override
	public String getName() {
		return "MIN";
	}

	@Override
	public IFeature getFeature() {
		return getAutomaton().getFeature();
	}

	@Override
	public int getDefault() {
		return getFeature().getMax();
	}

	@Override
	public int apply(int a, int b) {
		return Math.min(a, b);
	}

}
