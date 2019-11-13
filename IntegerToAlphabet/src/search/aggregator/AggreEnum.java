package search.aggregator;

public enum AggreEnum {
	SUM, MAX, MIN;

	public static AggreEnum getAggregFromString(String s) {
		if (s.toUpperCase().equals("SUM")) {
			return SUM;
		} else if (s.toUpperCase().equals("MAX")) {
			return MAX;
		} else if (s.toUpperCase().equals("MIN")) {
			return MIN;
		}
		return null;
	}
}
