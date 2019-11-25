package features;

import features.impl.*;

public class FeatureFactory {
    public static IFeature createFeatureFromName(String featureName){
        switch (featureName.toUpperCase()){
            case "MAX":
                return new Max();
            case "MIN":
                return new Min();
            case "ONE":
                return new One();
            case "RANGE":
                return new Range();
            case "SURFACE":
                return new Surface();
            case "WIDTH":
                return new Width();
            default:
                return null;
        }
    }
}
