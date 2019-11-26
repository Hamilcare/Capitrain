package main.java.aggregators;

import main.java.aggregators.impl.Max;
import main.java.aggregators.impl.Min;
import main.java.aggregators.impl.Sum;

public class AggregatorFactory {
	public static IAggregator createAggregatorFromName(String name) {
		switch (name.toUpperCase()) {
		case "MAX":
			return new Max();
		case "MIN":
			return new Min();
		case "SUM":
			return new Sum();
		default:
			return null;
		}
	}
}
