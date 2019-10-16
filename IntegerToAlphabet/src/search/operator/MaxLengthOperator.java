package search.operator;

import java.util.regex.MatchResult;

public class MaxLengthOperator implements IOperator {

	MatchResult currentResult;
	
	static final String name ="MAX LENGTH";
	
	@Override
	public MatchResult currentResult() {
		return currentResult;
	}

	@Override
	public void compute(MatchResult currentMatch) {
		if(null == currentResult) {
			currentResult = currentMatch;
		} else {
			if(currentMatch.end() - currentMatch.start() > currentResult.end() - currentResult.start()) {
				currentResult = currentMatch;
			}
		}
	}

	@Override
	public String name() {
		return name;
	}

}
