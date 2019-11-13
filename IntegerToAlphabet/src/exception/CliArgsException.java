package exception;

public class CliArgsException extends Exception {

	static final String help = "usage : main -f <feature> -a <aggregator> -d <pathToDataFile>";
	private static final long serialVersionUID = 1L;

	public CliArgsException(String s) {
		super(s + help);
	}

}
