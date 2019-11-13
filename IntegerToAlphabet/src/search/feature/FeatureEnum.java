package search.feature;

public enum FeatureEnum {
	MAX_LENGTH, MIN_LENGTH, ONE, WIDHT, SURFACE, RANGE;

	public static FeatureEnum getFeatureFromString(String s) {
		if (s.toUpperCase().equals("MAX_LENGTH")) {
			return MAX_LENGTH;
		} else if (s.toUpperCase().equals("MIN_LENGTH")) {
			return MIN_LENGTH;
		} else if (s.toUpperCase().equals("ONE")) {
			return ONE;
		} else if (s.toUpperCase().equals("WIDHT")) {
			return WIDHT;
		} else if (s.toUpperCase().equals("SURFACE")) {
			return SURFACE;
		} else if (s.toUpperCase().equals("RANGE")) {
			return RANGE;
		}

		return null;

	}
}
