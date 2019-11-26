package aggregators;

import automaton.Automaton;
import automaton.IAutomaton;

public abstract class AbstractAggregator implements IAggregator {

	public AbstractAggregator() {

	}

	@Override
	public IAutomaton getAutomaton() {
		return Automaton.AUTOMATON;
	}

}
