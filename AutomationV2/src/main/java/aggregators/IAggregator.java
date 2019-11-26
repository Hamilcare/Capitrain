package main.java.aggregators;

import main.java.automaton.IAutomaton;
import main.java.features.IFeature;

public interface IAggregator {

	String getName();

	IFeature getFeature();

	int getDefault();

	int apply(int a, int b);

	IAutomaton getAutomaton();

}
