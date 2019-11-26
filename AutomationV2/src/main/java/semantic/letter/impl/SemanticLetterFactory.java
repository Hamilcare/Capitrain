package semantic.letter.impl;

import automaton.IAutomaton;
import semantic.letter.ISemanticLetter;

public class SemanticLetterFactory {

	public static ISemanticLetter getSemantic(String requestedLetter, IAutomaton automaton) {
		switch (requestedLetter.toUpperCase()) {
		case "IN":
			return new SemanticIn(automaton);
		case "OUT":
			return new SemanticOut(automaton);
		case "FOUND":
			return new SemanticLetterFound(automaton);
		case "FOUNDE":
			return new SemanticLetterFoundEnd(automaton);
		case "MAYBEB":
			return new SemanticMaybeB(automaton);
		case "MAYBEA":
			return new SemanticMaybeA(automaton);
		case "OUTA":
			return new SemanticOutA(automaton);
		case "OUTR":
			return new SemanticOutR(automaton);
		default:
			return null;
		}
	}

}
