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
public class PeakTest extends AbstractParameterizedTest {

	public PeakTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private List<AutomatonResult> expectedResult;

	@Parameterized.Parameters
	public static Collection dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
			{ new Max(), new Width(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", Arrays.asList(new AutomatonResult(3, 8, 10),new AutomatonResult(3, 12, 14)) },
			{ new Min(), new Width(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", Arrays.asList(new AutomatonResult(2, 4, 5)) },
//				{ new Max(), new Width(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", new AutomatonResult(3, 8, 10) },
//				{ new Min(), new Width(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", new AutomatonResult(2, 4, 5) },
//				{ new Min(), new features.impl.Max(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", new AutomatonResult(3, 12, 14)},
//				{ new Max(), new features.impl.Max(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", new AutomatonResult(6, 8, 10)},
//				{ new Max(), new features.impl.Surface(), "./resources/pattern/peak.csv", "./resources/input/catalogueExemples/peak", new AutomatonResult(14, 8, 10)},
		});
		// @formatter:on
	}

}
