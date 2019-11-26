package states;

import java.util.HashMap;

import states.impl.State;

public class StateFactory {
	static HashMap<String, IState> allStates = new HashMap<>();

	public static void builStateWithLabler(String label) {
		allStates.put(label, new State(label));
	}

	public static IState getStateFromLabel(String label) {
		return allStates.get(label);
	}

}
