package search.operator.booleanFunction;

import search.operator.OperatorEnum;
import search.operator.booleanFunction.impl.MaxLengthFunction;
import search.operator.booleanFunction.impl.MinLengthFunction;

public class BooleanFunctionFactory {
	
	public static IBooleanFunction getInstance(OperatorEnum ope) {
		switch(ope) {
		case MAX_LENGTH:
			return new MaxLengthFunction();
		
		case MIN_LENGTH:
			return new MinLengthFunction();
		
			default:
				return null;	
		}
	}

}
