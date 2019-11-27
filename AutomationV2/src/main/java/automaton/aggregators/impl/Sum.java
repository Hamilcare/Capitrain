package automaton.aggregators.impl;

import automaton.aggregators.AbstractAggregator;
import automaton.features.IFeature;

public class Sum extends AbstractAggregator {

	@Override
	public String getName() {
		return "SUM";
	}

	@Override
	public IFeature getFeature() {
		return getAutomaton().getFeature();
	}

	@Override
	public int getDefault() {
		return 0;
	}

	@Override
	public int apply(int a, int b) {

		return a + b;
	}

}
