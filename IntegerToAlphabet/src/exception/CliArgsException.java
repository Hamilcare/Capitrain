package exception;

public class CliArgsException extends Exception {

	static final String help = "usage : main -p <pattern -f <feature> -a <aggregator> -d <pathToDataFile> -c <pathToConfigFile>";
	private static final long serialVersionUID = 1L;

	public CliArgsException(String s) {
		super(s + help);
	}

}
