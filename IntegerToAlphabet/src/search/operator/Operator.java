package search.operator;

import java.util.regex.MatchResult;

import search.operator.booleanFunction.IBooleanFunction;

public class Operator implements IOperator{
	
	String name;
	MatchResult currentResult;
	IBooleanFunction function;
	
	public Operator(String name,  IBooleanFunction function) {
		super();
		this.name = name;
		this.function = function;
	}

	@Override
	public MatchResult currentResult() {
		return currentResult;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public IBooleanFunction booleanFunction() {
		return function;
	}

	@Override
	public void setCurrentResult(MatchResult newCurrentResult) {
		this.currentResult = newCurrentResult;
	}

}
