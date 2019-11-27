package parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import aggregators.IAggregator;
import aggregators.impl.Max;
import aggregators.impl.Min;
import automaton.AutomatonResult;
import features.IFeature;
import features.impl.Surface;
import features.impl.Width;

@RunWith(Parameterized.class)
public class SummitTest extends AbstractMinMaxParameterizedTest {

	public SummitTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	private static final String PATH_TO_PATTERN = "./resources/pattern/summit.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/summit/summit_width";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
			{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(3, 2, 4))},
			{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(1, 14, 14))},
			{ new Max(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(13, 2, 4))},
			{ new Min(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(3, 14, 14))},
			{ new Max(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(5, 2, 4))},
			{ new Min(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(3, 14, 14))},
		});

		// @formatter:on
	}
}
