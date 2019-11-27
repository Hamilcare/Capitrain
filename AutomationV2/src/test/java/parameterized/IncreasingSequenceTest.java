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

@RunWith(Parameterized.class)
public class IncreasingSequenceTest extends AbstractMinMaxParameterizedTest {

	public IncreasingSequenceTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
		// TODO Auto-generated constructor stub
	}

	private static final String PATH_TO_PATTERN = "./resources/pattern/increasing_sequence.csv";

	private static final String PATH_TO_INPUT = "./resources/input/catalogueExemples/increasingSequence/";

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
		return Arrays.asList(new Object[][] {	
				{ new Min(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT+"increasing_sequence_max", Arrays.asList(new AutomatonResult(3, 13, 13))},
				{ new Max(), new features.impl.Max(), PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", Arrays.asList(new AutomatonResult(6,6,9))},
				{ new Min(), new features.impl.Width(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", Arrays.asList(new AutomatonResult(2,1,1),new AutomatonResult(2,13,13))},
				{ new Max(), new features.impl.Width(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", Arrays.asList(new AutomatonResult(5,6,9))},
				{ new Min(), new features.impl.Surface(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", Arrays.asList(new AutomatonResult(4,13,13))},
				{ new Max(), new features.impl.Surface(),PATH_TO_PATTERN, PATH_TO_INPUT+  "increasing_sequence_max", Arrays.asList(new AutomatonResult(17,6,9))},
				
		});
		// @formatter:on
	}

}
