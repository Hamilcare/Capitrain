package features;

import automaton.IAutomaton;

public abstract class AbstractFeature implements IFeature {

	IAutomaton automaton;

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}
}
