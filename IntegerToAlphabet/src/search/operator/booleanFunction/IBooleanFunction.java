package search.operator.booleanFunction;

import java.util.regex.MatchResult;

public interface IBooleanFunction {
	public boolean op(MatchResult currentBestResult, MatchResult currentMatch);	
}
