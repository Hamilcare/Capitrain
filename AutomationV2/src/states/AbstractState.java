package states;

import java.util.HashMap;

import alphabet.Alphabet;
import transitions.ITransition;

public abstract class AbstractState implements IState {

	String label;
	HashMap<Alphabet, ITransition> transitions;

	public AbstractState(String label, HashMap<Alphabet, ITransition> transitions) {
		this.label = label;
		this.transitions = transitions;
	}

	public AbstractState(String label) {
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
