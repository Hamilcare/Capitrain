package main.java.features.impl;

import main.java.application.Main;
import main.java.automaton.Automaton;
import main.java.features.AbstractFeature;

public class Max extends AbstractFeature {
	@Override
	public String getName() {
		return "MAX";
	}

	@Override
	public int getNeutral() {
		return Integer.MIN_VALUE;
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
		return Math.max(a, b);
	}

	@Override
	public int getValue() {
//		return Main.translator.getTextToTranslate().get(Automaton.AUTOMATON.getCurrentXiPosition());
		return Main.translator.getInputAtIndex(Automaton.AUTOMATON.getCurrentXiPosition());
	}
}
