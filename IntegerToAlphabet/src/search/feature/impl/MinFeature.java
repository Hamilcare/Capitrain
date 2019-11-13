package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

import java.util.Collections;

public class MinFeature extends Feature {
    public MinFeature(String name) { super(name); }

    @Override
    public int compute(IOccurence occurence) {
        return Collections.min(occurence.eSequence());
    }
}
