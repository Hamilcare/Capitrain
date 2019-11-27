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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		result = prime * result + x1;
		result = prime * result + x2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutomatonResult other = (AutomatonResult) obj;
		if (value != other.value)
			return false;
		if (x1 != other.x1)
			return false;
		if (x2 != other.x2)
			return false;
		return true;
	}

}
