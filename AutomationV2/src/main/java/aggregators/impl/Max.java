package main.java.aggregators.impl;

import main.java.aggregators.AbstractAggregator;
import main.java.automaton.Automaton;
import main.java.features.IFeature;

public class Max extends AbstractAggregator {

	@Override
	public String getName() {
		return "MAX";
	}

	@Override
	public IFeature getFeature() {

		return Automaton.AUTOMATON.getFeature();
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
