package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

import java.util.Collections;

public class MaxFeature extends Feature {
    public MaxFeature(String name) { super(name); }

    @Override
    public int compute(IOccurence occurence) {
        return Collections.max(occurence.eSequence());
    }
}
