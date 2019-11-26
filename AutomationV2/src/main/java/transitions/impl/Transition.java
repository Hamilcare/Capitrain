package main.java.transitions.impl;

import main.java.alphabet.Alphabet;
import main.java.semantic.letter.ISemanticLetter;
import main.java.states.IState;
import main.java.transitions.ITransition;

public class Transition implements ITransition {

	Alphabet letter;
	ISemanticLetter semantic;
	IState target;

	public Transition(Alphabet letter, ISemanticLetter semantic, IState target) {
		super();
		this.letter = letter;
		this.semantic = semantic;
		this.target = target;
	}

	@Override
	public Alphabet getLetter() {
		return letter;
	}

	@Override
	public ISemanticLetter getSemantic() {
		return semantic;
	}

	@Override
	public IState getTarget() {
		return target;
	}

}
