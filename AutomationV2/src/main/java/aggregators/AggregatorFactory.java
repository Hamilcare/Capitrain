package aggregators;

import aggregators.impl.Max;
import aggregators.impl.Min;
import aggregators.impl.Sum;

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
