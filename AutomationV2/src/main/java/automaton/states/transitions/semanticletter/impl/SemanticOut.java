package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;
import automaton.states.transitions.semanticletter.AbstractSemanticLetter;

public class SemanticOut extends AbstractSemanticLetter {

	public SemanticOut(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// Nothing to do
	}

	@Override
	public void updateAccC() {
		// Nothing to do
	}

	@Override
	public void updateAccD() {
		// Nothing to do
	}

}
