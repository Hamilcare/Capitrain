package main.java.semantic.letter.impl;

import main.java.automaton.IAutomaton;
import main.java.semantic.letter.AbstractSemanticLetter;

public class SemanticOutR extends AbstractSemanticLetter {

	public SemanticOutR(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// NothingToDo
		throw new UnsupportedOperationException("Word OutR should not update accumulator R");
	}

	@Override
	public void updateAccC() {
		// NothingToDo
		throw new UnsupportedOperationException("Word OutR should not update accumulator C");
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
