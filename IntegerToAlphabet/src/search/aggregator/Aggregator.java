package search.aggregator;

public abstract class Aggregator implements IAggregator{
    protected String name;
    protected int value;

    public Aggregator(String name){
        this.name = name;
    }

    public String name(){
        return this.name;
    }

    public int getValue(){
        return this.value;
    }
}