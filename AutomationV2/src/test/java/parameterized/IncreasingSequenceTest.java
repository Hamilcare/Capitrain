package parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import aggregators.IAggregator;
import aggregators.impl.Min;
import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
import features.IFeature;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

@RunWith(Parameterized.class)
public class IncreasingSequenceTest {
	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private AutomatonResult expectedResult;

	private static final String PATH_TO_PATTERN = "./resources/pattern/increasing_sequence.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/increasingSequence/";

	@Parameterized.Parameters
	public static Collection dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {	
//				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT, new AutomatonResult(3, 8, 10) },
//				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT, new AutomatonResult(2, 4, 5) },
//				{ new Min(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT, new AutomatonResult(3, 12, 14)},
//				{ new Max(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT, new AutomatonResult(6, 8, 10)},
				{ new Min(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT+"increasing_sequence_max", new AutomatonResult(3, 13, 15)},
		});
		// @formatter:on
	}

	public IncreasingSequenceTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			AutomatonResult expectedResult) {
		this.aggregator = aggregator;
		this.feature = feature;
		this.patternFilePath = patternFilePath;
		this.dataFilePath = dataFilePath;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testAutomaton() throws IOException {
		System.out.println(String.format("Testing with: %s %s %s %s", this.aggregator.getName(), this.feature.getName(),
				this.patternFilePath, this.dataFilePath));
		ITranslator translator = new OneLineFileTranslator(this.dataFilePath);

		IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(this.patternFilePath, this.feature, this.aggregator,
				translator);
		AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
		AutomatonResult result = automatonRunner.run();

		Assert.assertEquals("Value", this.expectedResult.getValue(), result.getValue());
		Assert.assertEquals("Borne inf.", this.expectedResult.getX1(), result.getX1());
		Assert.assertEquals("Borne sup.", this.expectedResult.getX2(), result.getX2());

	}

}
