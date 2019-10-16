package search.operator.booleanFunction.impl;

import java.util.regex.MatchResult;

import search.operator.booleanFunction.IBooleanFunction;

public class MaxLengthFunction implements IBooleanFunction{

	@Override
	public boolean op(MatchResult currentBestResult, MatchResult currentMatch) {
		return currentMatch.end() - currentMatch.start() > currentBestResult.end() - currentBestResult.start();
	}

}
