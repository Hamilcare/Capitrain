package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

public class WidthFeature extends Feature {
    public WidthFeature(String name) {
        super(name);
    }

    @Override
    public int compute(IOccurence occurence) {
        return occurence.eSequence().size();
    }
}