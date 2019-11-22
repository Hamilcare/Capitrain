package aggregators.impl;

import aggregators.AbstractAggregator;
import automaton.IAutomaton;
import features.IFeature;

public final class Min extends AbstractAggregator {

	public Min(IAutomaton automaton, IFeature feature) {
		super(automaton, feature);
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
