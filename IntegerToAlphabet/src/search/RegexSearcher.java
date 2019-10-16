package search;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import search.operator.IOperator;

public class RegexSearcher implements Runnable, Callable<String> {

	String name;
	Pattern pattern;
	Matcher matcher;
	int problemSize;
	IOperator operator;

	public RegexSearcher(String name, String regex, String textToSearch) {
		this.name = name;
		pattern = Pattern.compile(regex);
		matcher = this.pattern.matcher(textToSearch);
		problemSize = textToSearch.length();
	}

	public RegexSearcher(String name, String regex, String textToSearch, IOperator operator) {
		this.name = name;
		pattern = Pattern.compile(regex);
		matcher = this.pattern.matcher(textToSearch);
		problemSize = textToSearch.length();
		this.operator = operator;
	}

	public void run() {
		int cpt = 0;
		int lastMatch = 0;
		while (matcher.find()) {
			cpt++;
			if (cpt % 10000 == 0 && cpt != lastMatch) {
//				System.out.println("Pattern : "+name+" : "+(double)matcher.end()/problemSize*100);//(matcher.end()/problemSize*100)+" %");
				lastMatch = cpt;
			}
			if (hasOperator()) {
				operator.compute(matcher.toMatchResult());
			}
		}
		if (hasOperator()) {
			System.out.println(name + " ==> " + operator.getCurrentResultAsString());
		} else {
			System.out.println("Le motif " + name + " a été repéré " + cpt + " fois (" + this.pattern.pattern() + ")");
		}
	}

	private boolean hasOperator() {
		return null != operator;
	}

	@Override
	public String call() throws Exception {
		run();
		return this.name;
	}

}
