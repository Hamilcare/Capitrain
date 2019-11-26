package main.java.features;

import main.java.features.impl.Max;
import main.java.features.impl.Min;
import main.java.features.impl.One;
import main.java.features.impl.Range;
import main.java.features.impl.Surface;
import main.java.features.impl.Width;

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
