package aggregators;

import automaton.IAutomaton;
import features.IFeature;

public interface IAggregator {

	String getName();

	IFeature getFeature();

	int getDefault();

	int apply(int a, int b);

	IAutomaton getAutomaton();

	void setAutomaton(IAutomaton automaton);

}
