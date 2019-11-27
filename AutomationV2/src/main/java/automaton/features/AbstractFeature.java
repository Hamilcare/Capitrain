package automaton.features;

import automaton.IAutomaton;

public abstract class AbstractFeature implements IFeature {

	IAutomaton automaton;

	@Override
	public IAutomaton getAutomaton() {
		return this.automaton;
	}

	@Override
	public void setAutomaton(IAutomaton automaton) {
		this.automaton = automaton;
	}
}
