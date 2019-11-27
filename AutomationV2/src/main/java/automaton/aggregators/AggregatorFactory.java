package automaton.aggregators;

import automaton.aggregators.impl.Max;
import automaton.aggregators.impl.Min;
import automaton.aggregators.impl.Sum;

public class AggregatorFactory {

	private AggregatorFactory() {
		// Sonar
	};

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
