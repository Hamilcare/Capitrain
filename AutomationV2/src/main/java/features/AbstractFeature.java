package main.java.features;

import main.java.automaton.Automaton;
import main.java.automaton.IAutomaton;

public abstract class AbstractFeature implements IFeature {

	@Override
	public IAutomaton getAutomaton() {
		return Automaton.AUTOMATON;
	}
}
