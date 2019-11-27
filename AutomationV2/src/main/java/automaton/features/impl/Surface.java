package automaton.features.impl;

import automaton.features.AbstractFeature;

public class Surface extends AbstractFeature {
	@Override
	public String getName() {
		return "SURFACE";
	}

	@Override
	public int getNeutral() {
		return 0;
	}

	@Override
	public int getMin() {
		return Integer.MIN_VALUE;
	}

	@Override
	public int getMax() {
		return Integer.MAX_VALUE;
	}

	@Override
	public int apply(int a, int b) {
		return a + b;
	}

	@Override
	public int getValue(int xi) {
		return getAutomaton().getTranslator().getInputAtIndex(getAutomaton().getCurrentXiPosition() + xi);
	}

}
