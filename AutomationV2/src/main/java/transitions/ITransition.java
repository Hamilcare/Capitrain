package main.java.transitions;

import main.java.alphabet.Alphabet;
import main.java.semantic.letter.ISemanticLetter;
import main.java.states.IState;

public interface ITransition {

	Alphabet getLetter();

	default IState applyTransition() {
		getSemantic().applySemantic();
		return getTarget();
	}

	ISemanticLetter getSemantic();

	IState getTarget();

}
