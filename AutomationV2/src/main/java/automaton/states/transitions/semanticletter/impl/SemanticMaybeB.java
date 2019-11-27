package automaton.states.transitions.semanticletter.impl;

import automaton.IAutomaton;
import automaton.states.transitions.semanticletter.AbstractSemanticLetter;

public class SemanticMaybeB extends AbstractSemanticLetter {

	public SemanticMaybeB(IAutomaton automaton) {
		super(automaton);
	}

	@Override
	public void updateAccR() {
		// Nothing to do
	}

	@Override
	public void updateAccC() {
		// Nothing to do
	}

	@Override
	public void updateAccD() {
		int newValue = getAutomaton().getFeature().apply(getAutomaton().getAccumulatorD().getCurrentValue(),
				getAutomaton().getFeature().getValue(0));
		getAutomaton().getAccumulatorD().updateValue(newValue);
	}

}
