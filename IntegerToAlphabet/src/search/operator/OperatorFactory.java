package search.operator;

import search.operator.booleanFunction.BooleanFunctionFactory;

public class OperatorFactory {
	public static Operator getOperator(OperatorEnum ope) {
			return new Operator("Max Length", BooleanFunctionFactory.getInstance(ope));		
	}
}
