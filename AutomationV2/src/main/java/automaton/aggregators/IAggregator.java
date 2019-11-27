package automaton.aggregators;

import automaton.IAutomaton;
import automaton.features.IFeature;

public interface IAggregator {

	String getName();

	IFeature getFeature();

	int getDefault();

	int apply(int a, int b);

	IAutomaton getAutomaton();

	void setAutomaton(IAutomaton automaton);

}
