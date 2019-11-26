package aggregators.impl;

import aggregators.AbstractAggregator;
import automaton.Automaton;
import features.IFeature;

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
