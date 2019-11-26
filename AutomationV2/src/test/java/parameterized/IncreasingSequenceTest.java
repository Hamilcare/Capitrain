package parameterized;

import static utils.Utils.NA;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import aggregators.IAggregator;
import aggregators.impl.Max;
import aggregators.impl.Min;
import aggregators.impl.Sum;
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
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {	
				{ new Min(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT+"increasing_sequence_max", new AutomatonResult(3, 13, 13)},
				{ new Max(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(6,6,9)},
				{ new Min(), new features.impl.Width(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(2,1,1)},
				{ new Max(), new features.impl.Width(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(5,6,9)},
				{ new Min(), new features.impl.Surface(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(4,13,13)},
				{ new Max(), new features.impl.Surface(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(17,6,9)},
				{ new Sum(), new features.impl.One() ,PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(3,NA,NA)},
				{ new Sum(), new features.impl.Surface() ,PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", new AutomatonResult(29,NA,NA)}
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
		if (expectedResult.getX1() != NA) {
			Assert.assertEquals("Borne inf.", this.expectedResult.getX1(), result.getX1());
			Assert.assertEquals("Borne sup.", this.expectedResult.getX2(), result.getX2());
		}

	}

}
