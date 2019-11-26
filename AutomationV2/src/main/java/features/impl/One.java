package features.impl;

import features.AbstractFeature;

public class One extends AbstractFeature {

	@Override
	public String getName() {
		return "one";
	}

	@Override
	public int getNeutral() {
		return 1;
	}

	@Override
	public int getMin() {
		return 1;
	}

	@Override
	public int getMax() {
		return 1;
	}

	@Override
	public int apply(int a, int b) {
		return Math.max(a, b);
	}

	@Override
	public int getValue(int xi) {
		return 0;
	}

}
