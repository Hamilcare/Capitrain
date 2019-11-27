package automaton.states.transitions.impl;

import alphabet.Alphabet;
import automaton.states.transitions.semanticletter.ISemanticLetter;
import automaton.states.IState;
import automaton.states.transitions.ITransition;

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
