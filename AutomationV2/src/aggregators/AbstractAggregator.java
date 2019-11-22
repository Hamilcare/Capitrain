package aggregators;

import automaton.IAutomaton;
import features.IFeature;

public abstract class AbstractAggregator implements IAggregator {

	IAutomaton automaton;

	IFeature feature;

	public AbstractAggregator(IAutomaton automaton, IFeature feature) {
		this.automaton = automaton;
		this.feature = feature;
	}

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}

}
