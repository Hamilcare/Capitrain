package search.operator.booleanFunction;

import java.util.regex.MatchResult;

public class MaxLengthFunction implements IBooleanFunction{

	@Override
	public boolean op(MatchResult currentBestResult, MatchResult currentMatch) {
		return currentMatch.end() - currentMatch.start() > currentBestResult.end() - currentBestResult.start();
	}

}
