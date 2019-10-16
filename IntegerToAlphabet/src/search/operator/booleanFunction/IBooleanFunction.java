package search.operator.booleanFunction;

import java.util.regex.MatchResult;

/**
 * La fonction passée à l'Operator 
 * @author valentin
 *
 */
public interface IBooleanFunction {
	public boolean op(MatchResult currentBestResult, MatchResult currentMatch);	
}
