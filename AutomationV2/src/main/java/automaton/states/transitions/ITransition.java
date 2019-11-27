package automaton.states.transitions;

import alphabet.Alphabet;
import automaton.states.transitions.semanticletter.ISemanticLetter;
import automaton.states.IState;

public interface ITransition {

	Alphabet getLetter();

	default IState applyTransition() {
		getSemantic().applySemantic();
		return getTarget();
	}

	ISemanticLetter getSemantic();

	IState getTarget();

}
