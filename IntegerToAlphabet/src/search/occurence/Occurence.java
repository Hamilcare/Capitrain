package search.occurence;

import java.util.List;

/**
 * 
 * @author valentin Stock la s, e et i occurence d'un pattern
 * 
 *         s-occurrences : maximal signature sequence matching r i-occurrences :
 *         do not overlap (footprint of the pattern) e-occurrences : used to
 *         compute the feature value
 */
public class Occurence implements IOccurence {

	// s-occurrences : maximal signature sequence matching r
	int sLowerBound;
	int sUpperBound;

	// i-occurrences : do not overlap (footprint of the pattern)
	int eLowerBound;
	int eUpperBound;

	// e-occurrences : used to compute the feature value
	int iLowerBound;
	int iUpperBound;

	List<Integer> eSequence;

	// public static IOccurence buildOccurenceFromMatch(MatchResult match, int before, int after, List<Integer> matchedInput) {
	// 	int i = match.start();
	// 	int j = match.end();
	// 	return new Occurence(i, j, i + before, j + 1 - after, i + before, j);
	// }

	public static IOccurence buildOccurenceFromMatch(List<Integer> eSequence){
		return new Occurence(eSequence);
	}

	public Occurence(int sLowerBound, int sUpperBound, int eLowerBound, int eUpperBound, int iLowerBound,
			int iUpperBound) {
		super();
		this.sLowerBound = sLowerBound;
		this.sUpperBound = sUpperBound;
		this.eLowerBound = eLowerBound;
		this.eUpperBound = eUpperBound;
		this.iLowerBound = iLowerBound;
		this.iUpperBound = iUpperBound;
	}

	public Occurence(List<Integer> eSequence){
		this.eSequence = eSequence;
	}

	// @Override
	// public int sLowerBound() {
	// 	return sLowerBound;
	// }

	// @Override
	// public int sUpperBound() {
	// 	return sUpperBound;
	// }

	// @Override
	// public int eLowerBound() {

	// 	return eLowerBound;
	// }

	// @Override
	// public int eUpperBound() {
	// 	return eUpperBound;
	// }

	// @Override
	// public int iLowerBound() {
	// 	return iLowerBound;
	// }

	// @Override
	// public int iUpperBound() {
	// 	return iUpperBound;
	// }

	public void setsLowerBound(int sLowerBound) {
		this.sLowerBound = sLowerBound;
	}

	public void setsUpperBound(int sUpperBound) {
		this.sUpperBound = sUpperBound;
	}

	public void seteLowerBound(int eLowerBound) {
		this.eLowerBound = eLowerBound;
	}

	public void seteUpperBound(int eUpperBound) {
		this.eUpperBound = eUpperBound;
	}

	public void setiLowerBound(int iLowerBound) {
		this.iLowerBound = iLowerBound;
	}

	public void setiUpperBound(int iUpperBound) {
		this.iUpperBound = iUpperBound;
	}

	@Override
	public List<Integer> eSequence() {
		
		return null;
	}
	
	
	
	
	
}
