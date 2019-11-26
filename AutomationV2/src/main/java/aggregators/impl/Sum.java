package main.java.aggregators.impl;

import main.java.aggregators.AbstractAggregator;
import main.java.automaton.Automaton;
import main.java.features.IFeature;

public class Sum extends AbstractAggregator {

	@Override
	public String getName() {
		return "SUM";
	}

	@Override
	public IFeature getFeature() {
		return Automaton.AUTOMATON.getFeature();
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
