package automaton;

public class AutomatonResult {
	private int value;
	private int x1;
	private int x2;

	public int getValue() {
		return value;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public AutomatonResult(int value, int x1, int x2) {
		this.value = value;
		this.x1 = x1;
		this.x2 = x2;
	}

}
