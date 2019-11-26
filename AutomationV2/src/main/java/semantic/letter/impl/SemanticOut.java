package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.AbstractSemanticLetter;

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
