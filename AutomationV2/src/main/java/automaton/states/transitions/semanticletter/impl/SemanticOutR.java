package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;
import automaton.states.transitions.semanticletter.AbstractSemanticLetter;

public class SemanticOutR extends AbstractSemanticLetter {

	public SemanticOutR(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// NothingToDo
	}

	@Override
	public void updateAccC() {
		// NothingToDo
	}

	@Override
	public void updateAccD() {
		getAutomaton().getAccumulatorD().setToInitValue();
	}

}
