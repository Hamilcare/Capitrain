package search.aggregator.impl;

import search.aggregator.Aggregator;

public class MaxAggregator extends Aggregator {
    
	
    public MaxAggregator(String name) {
        super(name);
        this.value = Integer.MIN_VALUE;
    }

    @Override
    public void compute(int featureValue) {
        if(this.value < featureValue){
            this.value = featureValue;
        }
    }
}