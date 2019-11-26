package states.impl;

import java.util.HashMap;

import alphabet.Alphabet;
import states.IState;
import transitions.ITransition;

public class State implements IState {

	String label;
	HashMap<Alphabet, ITransition> transitions;

	public State(String label, HashMap<Alphabet, ITransition> transitions) {
		this.label = label;
		this.transitions = transitions;
	}

	public State(String label) {
		this.label = label;
		this.transitions = new HashMap<>();
	}

	public void addTransition(ITransition transition) {
		transitions.put(transition.getLetter(), transition);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public ITransition getTransition(Alphabet input) {
		return transitions.get(input);
	}

}
