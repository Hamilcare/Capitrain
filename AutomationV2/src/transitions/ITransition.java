package transitions;

import alphabet.Alphabet;
import semantic.letter.ISemanticLetter;
import states.IState;

public interface ITransition {

	Alphabet getLetter();

	default IState applyTransition() {
		getSemantic().applySemantic();
		return getTarget();
	}

	ISemanticLetter getSemantic();

	IState getTarget();

}
