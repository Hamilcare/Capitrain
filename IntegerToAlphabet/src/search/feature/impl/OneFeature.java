package search.feature.impl;

import search.feature.Feature;
import search.occurence.IOccurence;

public class OneFeature extends Feature{
    public OneFeature(String name){
        super(name);
    }

    @Override
    public int compute(IOccurence occurence){
        return 1;
    }
}