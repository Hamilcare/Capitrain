package search.feature;

import search.occurence.IOccurence;

/**
 * A l'aide d'une {{@link #booleanFunction()} réalise une opération sur les
 * résultats au fur et a mesure du matching
 * 
 *
 */
public interface IFeature {
	/**
	 * @return le nom de l'opérateurIBooleanFunction function
	 */
	String name();

	/**
	 * Compute the result of the feature for the given occurence
	 */
	int compute(IOccurence occurence);

}
