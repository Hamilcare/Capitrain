package main;

import states.AbstractState;
import states.IState;

public class MinWidthPeak implements IAutomaton {

	int R;
	int C;
	int D;

	final int size;

	IState currentState;

	public MinWidthPeak(int size) {
		R = size;
		C = size;
		D = 0;
		this.size = size;
		currentState = AbstractState.getInitState(this);
	}

	@Override
	public int getD() {
		return D;
	}

	@Override
	public void setD(int value) {
		D = value;
	}

	@Override
	public int getR() {
		return R;
	}

	@Override
	public void setR(int value) {
		R = value;

	}

	@Override
	public int getC() {
		return C;
	}

	@Override
	public void setC(int value) {
		this.C = value;
	}

	@Override
	public int getSerieSize() {
		return size;
	}

	@Override
	public int getResult() {
		return Math.min(R, C);
	}

	@Override
	public void applyNextInput(char nextInput) {
		IState nextState = currentState.applyTransitions(nextInput);
//		System.out.println(nextInput + " : " + nextState.getLabel());

		this.currentState = nextState;
	}

}
