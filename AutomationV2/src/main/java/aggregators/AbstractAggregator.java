package main.java.aggregators;

import main.java.automaton.Automaton;
import main.java.automaton.IAutomaton;

public abstract class AbstractAggregator implements IAggregator {

	public AbstractAggregator() {

	}

	@Override
	public IAutomaton getAutomaton() {
		return Automaton.AUTOMATON;
	}

}
