package automaton.features;

import automaton.features.impl.Max;
import automaton.features.impl.Min;
import automaton.features.impl.One;
import automaton.features.impl.Range;
import automaton.features.impl.Surface;
import automaton.features.impl.Width;

public class FeatureFactory {
	public static IFeature createFeatureFromName(String featureName) {
		switch (featureName.toUpperCase()) {
		case "MAX":
			return new Max();
		case "MIN":
			return new Min();
		case "ONE":
			return new One();
		case "RANGE":
			return new Range();
		case "SURF":
			return new Surface();
		case "WIDTH":
			return new Width();
		default:
			return null;
		}
	}
}
