package main.java.aggregators.impl;

import main.java.aggregators.AbstractAggregator;
import main.java.features.IFeature;

public final class Min extends AbstractAggregator {

	public Min() {

	}

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
