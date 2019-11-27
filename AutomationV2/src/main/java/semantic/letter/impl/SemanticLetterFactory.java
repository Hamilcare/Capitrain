package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.ISemanticLetter;

public class SemanticLetterFactory {

	public static ISemanticLetter getSemantic(String requestedLetter, IAutomaton automaton, int after) {
		switch (requestedLetter.toUpperCase()) {
		case "IN":
			if (after == 0) {
				return new SemanticIn0(automaton);
			} else {
				return new SemanticIn(automaton);
			}
		case "OUT":
			return new SemanticOut(automaton);
		case "FOUND":
			if (after == 0) {
				return new SemanticLetterFound0(automaton);
			} else {
				return new SemanticLetterFound(automaton);
			}
		case "FOUNDE":
			if (after == 0) {
				return new SemanticLetterFoundEnd0(automaton);
			} else {
				return new SemanticLetterFoundEnd(automaton);
			}
		case "MAYBEB":
			return new SemanticMaybeB(automaton);
		case "MAYBEA":
			if (after == 0) {
				return new SemanticMaybeA0(automaton);
			} else {
				return new SemanticMaybeA(automaton);
			}
		case "OUTA":
			return new SemanticOutA(automaton);
		case "OUTR":
			return new SemanticOutR(automaton);
		default:
			return null;
		}
	}

}
