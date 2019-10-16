package search.operator;

import java.util.regex.MatchResult;

public interface IOperator {
	
	/**
	 * @return l'actuel meilleur résultat
	 */
	MatchResult currentResult();
	
	/**
	 * @return le nom de l'opérateur
	 */
	String name();
	
	/**
	 * Regarde si le param est meilleur que le résultat stocké précedemment
	 * @param currentMatch
	 */
	void compute(MatchResult currentMatch);
	
	/**
	 * print result in a readable way
	 * @return
	 */
	default String getCurrentResultAsString() {
		return name()+" : " + (currentResult().end()-currentResult().start()); 
	}
	
}
