package search.aggregator;

public interface IAggregator{
    public String name();

    void compute(int featureValue);
    int getValue();
}