package search.aggregator.impl;

import search.aggregator.Aggregator;

public class MinAggregator extends Aggregator {
    
    public MinAggregator(String name) {
        super(name);
        this.value = Integer.MAX_VALUE;
    }

    @Override
    public void compute(int featureValue) {
        if (this.value > featureValue) {
            this.value = featureValue;
        }
    }
}