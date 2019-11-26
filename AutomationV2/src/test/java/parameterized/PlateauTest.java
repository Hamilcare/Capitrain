package parameterized;

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
import features.impl.Surface;
import features.impl.Width;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

@RunWith(Parameterized.class)
public class PlateauTest {
	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private AutomatonResult expectedResult;

	private static final String PATH_TO_PATTERN = "./resources/pattern/plateau.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/plateau/";

	@Parameterized.Parameters
	public static Collection dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_width.test",new AutomatonResult(4, 3, 6) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_width.test",new AutomatonResult(3, 8, 10) },
				{ new Max(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_surf.test", new AutomatonResult(10, 11, 12)},
				{ new Min(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_surf.test", new AutomatonResult(3, 3, 3)}
				
		});

		// @formatter:on
	}

	public PlateauTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
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
