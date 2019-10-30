package search.aggregator;

import search.aggregator.impl.MaxAggregator;
import search.aggregator.impl.MinAggregator;
import search.aggregator.impl.SumAggregator;

public class AggreFactory {
    public static IAggregator getAggregator(AggreEnum aggreEnum){
        switch(aggreEnum){
            case SUM:
                return new SumAggregator("Sum");
            case MAX:
                return new MaxAggregator("Max");
            case MIN:
                return new MinAggregator("Min");
            default:
                throw new UnsupportedOperationException("Aggregator not implemented");

       }
    }
}