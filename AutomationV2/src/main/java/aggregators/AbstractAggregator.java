package aggregators;

import automaton.IAutomaton;

public abstract class AbstractAggregator implements IAggregator {

	IAutomaton automaton;

	public AbstractAggregator() {

	}

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}

	@Override
	public void setAutomaton(IAutomaton automaton) {
		this.automaton = automaton;
	}

}
