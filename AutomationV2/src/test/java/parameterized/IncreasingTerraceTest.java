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
import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
import features.IFeature;
import features.impl.Width;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

@RunWith(Parameterized.class)
public class IncreasingTerraceTest {
	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private AutomatonResult expectedResult;

	private static final String PATH_TO_PATTERN = "./resources/pattern/increasing_terrace.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/increasingTerrace/terrace_width";

	@Parameterized.Parameters
	public static Collection dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,new AutomatonResult(3, 11, 13) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,new AutomatonResult(2, 5, 6) },
				{ new Max(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,new AutomatonResult(10, 5, 6) },
				{ new Min(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,new AutomatonResult(9, 11, 13) }
				
		});

		// @formatter:on
	}

	public IncreasingTerraceTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
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
