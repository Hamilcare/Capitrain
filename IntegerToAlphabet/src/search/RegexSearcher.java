package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import search.aggregator.AggreEnum;
import search.aggregator.AggreFactory;
import search.aggregator.IAggregator;
import search.feature.FeatureEnum;
import search.feature.FeatureFactory;
import search.feature.IFeature;
import search.occurence.IOccurence;
import search.occurence.Occurence;

public class RegexSearcher implements Runnable, Callable<String> {

	/**
	 * le nom du pattern
	 */
	String name;
	/**
	 * Contient le pattern sous forme de regex
	 */
	Pattern pattern;

	Matcher matcher;

	/**
	 * longueur de la chaine en entrée
	 */
	int problemSize;

	/**
	 * La feature
	 */
	IFeature feature;

	/**
	 * La fonction d'aggregation
	 */
	IAggregator aggregator;

	/**
	 * l'input sous forme d'entier
	 */
	List<Integer> rawInput;

	/**
	 * 
	 * @param name
	 * @param regex
	 * @param textToSearch
	 * @param feature
	 * @param aggregator
	 */
	public RegexSearcher(String name, String regex, List<Integer> rawInput, String textToSearch, FeatureEnum feature,
			AggreEnum aggregator) {
		this.name = name;
		this.rawInput = rawInput;
		pattern = Pattern.compile(regex);
		matcher = this.pattern.matcher(textToSearch);
		problemSize = textToSearch.length();
		this.feature = FeatureFactory.getFeature(feature);
		this.aggregator = AggreFactory.getAggregator(aggregator);
	}

	@SuppressWarnings("unused")
	public void run() {
		int cpt = 0;
		int lastMatch = 0;

		/*
		 * #### Step 1 compute s #### s-occurrences : maximal signature sequence
		 * matching r i-occurrences : do not overlap (footprint of the pattern)
		 * e-occurrences : used to compute the feature value
		 */

//		Collection<IOccurence> toutesLesOccurencesDuPattern = getAllOccurences();
//
//		// #### Step 2 calcul de la feature pour chaque occurence ####
//		Collection<Integer> featureValues = toutesLesOccurencesDuPattern.stream()
//				.map(occurence -> feature.compute(occurence)).collect(Collectors.toList());
//
//		// #### Step 3 calcul de la valeur de l'aggregation
//		featureValues.forEach(value -> aggregator.compute(value));

		long startCompute = System.currentTimeMillis();
		compute();
		long endCompute = System.currentTimeMillis();
		System.out.println("Le pattern " + name + " est présent :" + aggregator.getValue());
		System.out.println("Recherche en " + (endCompute - startCompute) + " ms");
	}

	private Collection<IOccurence> getAllOccurences() {
		Collection<IOccurence> toutesLesOccurencesDuPattern = new ArrayList<IOccurence>();
		while (matcher.find()) {
			// @TODO avoir les vraies valeurs de before et after
			MatchResult currentMatch = matcher.toMatchResult();
			toutesLesOccurencesDuPattern
					.add(Occurence.buildOccurenceFromMatch(rawInput.subList(currentMatch.start(), currentMatch.end())));
		}

		return toutesLesOccurencesDuPattern;
	}

	private void compute() {
		while (matcher.find()) {
			MatchResult currentMatch = matcher.toMatchResult();
			aggregator.compute(feature.compute(
					Occurence.buildOccurenceFromMatch(rawInput.subList(currentMatch.start(), currentMatch.end()))));
		}
	}

	public String call() throws Exception {
		run();
		return name;
	}

}
