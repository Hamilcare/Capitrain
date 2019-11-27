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

@RunWith(Parameterized.class)
public class IncreasingTest extends AbstractMinMaxParameterizedTest {

	public IncreasingTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
			List<AutomatonResult> expectedResult) {
		super(aggregator, feature, patternFilePath, dataFilePath, expectedResult);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> dataSet() {
		// @formatter:off
        return Arrays.asList(new Object[][] {
        		{ new Min(), new Surface(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(4, 6, 6),new AutomatonResult(4, 13, 13)) },
                { new Max(), new Surface(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(10, 9, 9)) },
                { new Max(), new features.impl.Max(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(6, 9, 9)) },
                { new Min(), new features.impl.Max(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(3, 6, 6),new AutomatonResult(3, 13, 13)) },
                { new Min(), new features.impl.Min(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(1, 6, 6),new AutomatonResult(1, 13, 13)) },
                { new Max(), new features.impl.Min(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", Arrays.asList(new AutomatonResult(4, 9, 9)) },
        });
     // @formatter:on
	}

}
