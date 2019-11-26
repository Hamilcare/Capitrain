package main.java.alphabet;

public enum Alphabet {
	MORE("<"), LESS(">"), EQUALS("="), UNKOWN("?!?");

	private final String asString;

	public String asString() {
		return asString;
	}

	public static Alphabet asEnum(String s) {
		switch (s) {
		case "<":
			return MORE;
		case ">":
			return LESS;
		case "=":
			return EQUALS;
		default:
			return UNKOWN;
		}
	}

	public static Alphabet asEnum(char s) {
		switch (s) {
		case '<':
			return MORE;
		case '>':
			return LESS;
		case '=':
			return EQUALS;
		default:
			return UNKOWN;
		}
	}

	Alphabet(String s) {
		asString = s;
	}

}
