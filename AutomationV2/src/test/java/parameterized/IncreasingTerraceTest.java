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
import features.impl.Width;

@RunWith(Parameterized.class)
public class IncreasingTerraceTest extends AbstractMinMaxParameterizedTest {

	public IncreasingTerraceTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	private static final String PATH_TO_PATTERN = "./resources/pattern/increasing_terrace.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/increasingTerrace/terrace_width";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(3, 11, 13)) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(2, 5, 6)) },
				{ new Max(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(10, 5, 6)) },
				{ new Min(), new features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT,Arrays.asList(new AutomatonResult(9, 11, 13)) }
				
		});

		// @formatter:on
	}

}
