package search.aggregator.impl;

import search.aggregator.Aggregator;

public class SumAggregator extends Aggregator {
    
    public SumAggregator(String name){
        super(name);
        this.value = 0;
    }

    @Override
    public void compute(int featureValue){
        this.value += featureValue;
    }
}