package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

public class RangeFeature extends Feature {
    public RangeFeature(String name) { super(name); }

    @Override
    public int compute(IOccurence occurence) {
        MaxFeature max = new MaxFeature("max");
        MinFeature min = new MinFeature("min");
        return max.compute(occurence) - min.compute(occurence);
    }
}
