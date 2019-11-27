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
public class PeakTest extends AbstractMinMaxParameterizedTest {

	private static final String RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK = "./resources/input/catalogueExemples/peak";
	private static final String RESOURCES_PATTERN_PEAK_CSV = "./resources/pattern/peak.csv";

	public PeakTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
			{ new Max(), new Width(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(3, 8, 10),new AutomatonResult(3, 12, 14)) },
			{ new Min(), new Width(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(2, 4, 5)) },
			{ new Min(), new features.impl.Max(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(3, 12, 14)) },
			{ new Max(), new features.impl.Max(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(6, 8, 10))},
			{ new Max(), new features.impl.Surface(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(14, 8, 10))},
			{ new Min(), new features.impl.Surface(), RESOURCES_PATTERN_PEAK_CSV, RESOURCES_INPUT_CATALOGUE_EXEMPLES_PEAK, Arrays.asList(new AutomatonResult(9, 4, 5	),new AutomatonResult(9, 12, 14))},
		});
		// @formatter:on
	}

}
