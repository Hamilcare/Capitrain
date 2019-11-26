package main.java.semantic.letter.impl;

import main.java.automaton.Automaton;
import main.java.semantic.letter.ISemanticLetter;

public class SemanticLetterFactory {

	static ISemanticLetter IN = new SemanticIn(Automaton.AUTOMATON);
	static ISemanticLetter OUT = new SemanticOut(Automaton.AUTOMATON);
	static ISemanticLetter FOUND = new SemanticLetterFound(Automaton.AUTOMATON);
	static ISemanticLetter MAYBEB = new SemanticMaybeB(Automaton.AUTOMATON);
	static ISemanticLetter MAYBEA = new SemanticMaybeA(Automaton.AUTOMATON);
	static ISemanticLetter OUTA = new SemanticOutA(Automaton.AUTOMATON);

	public static ISemanticLetter getSemantic(String requestedLetter) {
		switch (requestedLetter.toUpperCase()) {
		case "IN":
			return IN;
		case "OUT":
			return OUT;
		case "FOUND":
			return FOUND;
		case "MAYBEB":
			return MAYBEB;
		case "MAYBEA":
			return MAYBEA;
		case "OUTA":
			return OUTA;
		default:
			return null;
		}
	}

}
