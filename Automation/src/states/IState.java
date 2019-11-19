package states;

import main.IAutomaton;

public interface IState {

	IAutomaton getAutomaton();

	String getLabel();

	/**
	 * mange input et renvoie le state qui en découle
	 * 
	 * @param input
	 * @return
	 */
	IState applyTransitions(char input);

}
