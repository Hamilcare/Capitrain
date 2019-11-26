package main.java.features.impl;

import main.java.features.AbstractFeature;

public class Min extends AbstractFeature {
	@Override
	public String getName() {
		return "MIN";
	}

	@Override
	public int getNeutral() {
		return Integer.MAX_VALUE;
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
		return Math.min(a, b);
	}

	@Override
	public int getValue() {
		return getAutomaton().getTranslator().getInputAtIndex(getAutomaton().getCurrentXiPosition());
	}

}
