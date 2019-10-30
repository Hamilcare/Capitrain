package search.feature;

import search.feature.impl.OneFeature;

public class FeatureFactory {
	public static Feature getFeature(FeatureEnum ope) {
		switch(ope){
			case ONE:
				return new OneFeature("One");
			default:
				throw new UnsupportedOperationException("Feature not implemented");
		}
	}
}
