package features.impl;

import features.AbstractFeature;

public class One extends AbstractFeature {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "one";
	}

	@Override
	public int getNeutral() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMin() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int apply(int a, int b) {
		// TODO Auto-generated method stub
		return Math.max(a, b);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
