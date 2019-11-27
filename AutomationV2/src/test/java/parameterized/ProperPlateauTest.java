package parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import automaton.aggregators.IAggregator;
import automaton.aggregators.impl.Max;
import automaton.aggregators.impl.Min;
import automaton.impl.AutomatonResult;
import automaton.features.IFeature;
import automaton.features.impl.Width;

@RunWith(Parameterized.class)
public class ProperPlateauTest extends AbstractMinMaxParameterizedTest {

	public ProperPlateauTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	private static final String PATH_TO_PATTERN = "./resources/pattern/proper_plateau.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/properPlateau/";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {
				{ new Max(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",Arrays.asList(new AutomatonResult(3, 12, 14)) },
				{ new Min(), new Width(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",Arrays.asList(new AutomatonResult(2, 2, 3),new AutomatonResult(2, 7, 8)) },
				{ new Max(), new automaton.features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",Arrays.asList(new AutomatonResult(15, 12, 14)) },
				{ new Min(), new automaton.features.impl.Surface(), PATH_TO_PATTERN, PATH_TO_INPUT+"width_proper_plateau",Arrays.asList(new AutomatonResult(6, 2, 3))	 },
		});

		// @formatter:on
	}

}
