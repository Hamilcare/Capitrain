package utils;

import java.io.File;
import java.io.IOException;

import automaton.aggregators.AggregatorFactory;
import automaton.aggregators.IAggregator;
import automaton.features.FeatureFactory;
import automaton.features.IFeature;
import translation.ITranslator;
import translation.TranslatorFactory;

public class CliParser {

	private static final int NB_ARGS_REQUESTED = 5;
	private static final int POS_PATTERN_FILE = 0;
	private static final int POS_FEATURE = 2;
	private static final int POS_AGGREGATOR = 1;
	private static final int POS_DATA_FILE = 3;
	private static final int POS_PARSER_TYPE=4;

	private String[] args;

	private String patternFilePath;
	private IFeature feature;
	private IAggregator aggregator;
	private String dataFilePath;
	private ITranslator translator;

	public CliParser(String[] args) {
		this.args = args;
	}

	public void parse() throws CliParserException, IOException {
		if (args.length != NB_ARGS_REQUESTED) {
			throw new CliParserException("Wrong number of parameters : " + NB_ARGS_REQUESTED + " requested");
		}
		parsePatternFile();
		parseFeature();
		parseAggregator();
		parseDataFile();
		parseParserType();
	}

	private void parsePatternFile() throws CliParserException {
		this.patternFilePath = args[POS_PATTERN_FILE];
		File f = new File(this.patternFilePath);
		if (!f.exists() || f.isDirectory()) {
			throw new CliParserException("Pattern file " + args[POS_PATTERN_FILE] + " is not valid");
		}
	}

	private void parseFeature() throws CliParserException {
		String featureStr = args[POS_FEATURE];
		IFeature feature = FeatureFactory.createFeatureFromName(featureStr);
		if (feature == null) {
			throw new CliParserException("feature " + args[POS_FEATURE] + " is not valid");
		}
		this.feature = feature;
	}

	private void parseAggregator() throws CliParserException {
		String aggregatorStr = args[POS_AGGREGATOR];
		IAggregator aggregator = AggregatorFactory.createAggregatorFromName(aggregatorStr);
		if (aggregator == null) {
			throw new CliParserException("aggregator " + args[POS_AGGREGATOR] + " is not valid");
		}
		this.aggregator = aggregator;
	}

	private void parseDataFile() throws CliParserException {
		this.dataFilePath = args[POS_DATA_FILE];
		File f = new File(this.dataFilePath);
		if (!f.exists() || f.isDirectory()) {
			throw new CliParserException("Data file " + args[POS_DATA_FILE] + " is not valid");
		}
	}

	private void parseParserType() throws CliParserException, IOException {
		String parserName = args[POS_PARSER_TYPE];
		this.translator = TranslatorFactory.createTranslatorFromName(this.getDataFilePath(), parserName);
		if(this.translator == null){
			throw new CliParserException("Parser type " + args[POS_DATA_FILE] + " is not valid");
		}
	}

	public String getPatternFilePath() {
		return this.patternFilePath;
	}

	public IFeature getFeature() {
		return this.feature;
	}

	public IAggregator getAggregator() {
		return this.aggregator;
	}

	public String getDataFilePath() {
		return this.dataFilePath;
	}

	public ITranslator getTranslator() { return this.translator; }

}
