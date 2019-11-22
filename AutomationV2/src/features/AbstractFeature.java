package features;

import automaton.Automaton;
import automaton.IAutomaton;

public abstract class AbstractFeature implements IFeature {

	@Override
	public IAutomaton getAutomaton() {
		return Automaton.AUTOMATON;
	}
}
