package semantic.letter.impl;

import automaton.Automaton;
import semantic.letter.ISemanticLetter;

public class SemanticLetterFactory {

	static ISemanticLetter IN = null;

	public static ISemanticLetter getSemantic(String requestedLetter) {
		switch (requestedLetter.toUpperCase()) {
		case "IN":
			if (IN == null) {
				IN = new SemanticIn(Automaton.AUTOMATON);
			}
			return IN;

		default:
			return null;
		}
	}

}
