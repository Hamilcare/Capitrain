import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import parameterized.IncreasingSequenceTest;
import parameterized.IncreasingTerraceTest;
import parameterized.IncreasingTest;
import parameterized.PeakTest;
import parameterized.PlateauTest;
import parameterized.ProperPlateauTest;
import parameterized.StrictlyIncreasingSequenceTest;
import parameterized.SummitTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({ PeakTest.class, IncreasingTest.class, PlateauTest.class, IncreasingSequenceTest.class,
		IncreasingTerraceTest.class, ProperPlateauTest.class, SummitTest.class, StrictlyIncreasingSequenceTest.class })
public class Suite {

}
