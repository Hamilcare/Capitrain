package main.java.semantic.letter.impl;

import main.java.automaton.IAutomaton;
import main.java.semantic.letter.AbstractSemanticLetter;

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
