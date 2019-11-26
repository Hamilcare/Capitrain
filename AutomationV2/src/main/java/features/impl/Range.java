package features.impl;

import features.AbstractFeature;

public class Range extends AbstractFeature {
	@Override
	public String getName() {
		return "RANGE";
	}

	@Override
	public int getNeutral() {
		return 0;
	}

	@Override
	public int getMin() {
		return 0;
	}

	@Override
	public int getMax() {
		return Integer.MAX_VALUE;
	}

	@Override
	public int apply(int a, int b) {
		// TODO: return ??
		return 0;
	}

	@Override
	public int getValue() {
		return getAutomaton().getTranslator().getInputAtIndex(getAutomaton().getCurrentXiPosition());
	}

}
