package features;

import features.impl.Max;
import features.impl.Min;
import features.impl.One;
import features.impl.Range;
import features.impl.Surface;
import features.impl.Width;

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
