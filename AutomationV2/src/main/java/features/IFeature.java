package main.java.features;

import main.java.automaton.IAutomaton;

public interface IFeature {
	IAutomaton getAutomaton();

	String getName();

	int getNeutral();

	int getMin();

	int getMax();

	// fi
	int apply(int a, int b);

	// delta/ d_ronde
	int getValue();

}
