package states;

import alphabet.Alphabet;
import transitions.ITransition;

public interface IState {

	String getLabel();

	ITransition getTransition(Alphabet input);

	/**
	 * Applique la transition et renvoie le nouvel etat
	 */
	default IState applyTransition(Alphabet nextInput) {
		return getTransition(nextInput).applyTransition();
	}

	void addTransition(ITransition transition);

}
