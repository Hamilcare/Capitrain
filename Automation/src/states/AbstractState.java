package states;

import main.IAutomaton;

public abstract class AbstractState implements IState {

	// L'automate est partagé par tous les states
	static IAutomaton automaton;

	public static AbstractState getInitState(IAutomaton automaton) {
		AbstractState.automaton = automaton;
		return new StateD();
	}

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}

}
