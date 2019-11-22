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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDefault() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int apply(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IAutomaton getAutomaton() {
		// TODO Auto-generated method stub
		return null;
	}

}
