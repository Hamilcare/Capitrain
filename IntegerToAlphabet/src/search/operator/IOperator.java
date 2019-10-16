package search.operator;

import java.util.regex.MatchResult;

import search.operator.booleanFunction.IBooleanFunction;

/**
 * A l'aide d'une {{@link #booleanFunction()} réalise une opération sur les
 * résultats au fur et a mesure du matching
 * 
 *
 */
public interface IOperator {

	/**
	 * @return l'actuel meilleur résultat
	 */
	MatchResult currentResult();

	/**
	 * @return le nom de l'opérateur
	 */
	String name();

	IBooleanFunction booleanFunction();

	/**
	 * set currentResult
	 */
	void setCurrentResult(MatchResult newCurrentResult);

	/**
	 * Regarde si le param est meilleur que le résultat stocké précedemment
	 * 
	 * @param currentMatch
	 */

	default void compute(MatchResult currentMatch) {
		if (null == currentResult()) {
			setCurrentResult(currentMatch);
		} else {
			if (booleanFunction().op(currentResult(), currentMatch)) {
				setCurrentResult(currentMatch);
			}
		}
	}

	/**
	 * print result in a readable way
	 * 
	 * @return
	 */
	default String getCurrentResultAsString() {
		return name() + " : " + (currentResult().end() - currentResult().start());
	}

}
