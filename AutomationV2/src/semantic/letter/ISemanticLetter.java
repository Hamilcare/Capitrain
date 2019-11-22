package semantic.letter;

import automaton.IAutomaton;

public interface ISemanticLetter {

	IAutomaton getAutomaton();

	void updateAccR();

	void updateAccC();

	void updateAccD();
}
