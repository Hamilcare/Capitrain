package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

public class SurfFeature extends Feature {

    public SurfFeature(String name) {
        super(name);
    }

    @Override
    public int compute(IOccurence occurence) {
        return occurence.eSequence().stream().reduce(0, Integer::sum);
    }
}
