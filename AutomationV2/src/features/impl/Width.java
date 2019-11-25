package features.impl;

import features.AbstractFeature;

public class Width extends AbstractFeature {

	public Width() {
	}

	@Override
	public String getName() {
		return "WIDTH";
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
		return a + b;
	}

	@Override
	public int getValue() {
		return 1;
	}

}
