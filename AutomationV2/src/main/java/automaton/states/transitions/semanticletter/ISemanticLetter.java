package automaton.states.transitions.semanticletter;

import automaton.IAutomaton;

public interface ISemanticLetter {

	IAutomaton getAutomaton();

	default void applySemantic() {
		updateAccR();
		updateAccC();
		updateAccD();
	}

	void updateAccR();

	void updateAccC();

	void updateAccD();

}
