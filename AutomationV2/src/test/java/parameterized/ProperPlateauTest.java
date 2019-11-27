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
import features.impl.Width;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

@RunWith(Parameterized.class)
public class ProperPlateauTest {
	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private AutomatonResult expectedResult;

	private static final String PATH_TO_PATTERN = "./resources/pattern/proper_plateau.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/properPlateau/";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(3, 12, 14) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(2, 2, 3) },
				{ new Sum(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(7, NA, NA) },
				{ new Max(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(15, 12, 14) },
				{ new Min(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(6, 2, 3) },
				{ new Sum(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",new AutomatonResult(29, NA, NA) },
		});

		// @formatter:on
	}

	public ProperPlateauTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
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
