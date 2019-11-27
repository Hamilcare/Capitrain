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
public class PlateauTest extends AbstractMinMaxParameterizedTest {
	public PlateauTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	private static final String PATH_TO_PATTERN = "./resources/pattern/plateau.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/plateau/";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_width.test", Arrays.asList(new AutomatonResult(4, 3, 6)) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_width.test", Arrays.asList(new AutomatonResult(3, 8, 10)) },
				
				{ new Max(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_surf.test",Arrays.asList( new AutomatonResult(10, 11, 12))},
				{ new Min(), new Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"plateau_surf.test", Arrays.asList(new AutomatonResult(3, 3, 3))},
				

		});

		// @formatter:on
	}

}
