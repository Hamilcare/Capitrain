import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import parameterized.IncreasingSequenceTest;
import parameterized.IncreasingTerraceTest;
import parameterized.IncreasingTest;
import parameterized.PeakTest;
import parameterized.PlateauTest;
import parameterized.ProperPlateauTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({ PeakTest.class, PlateauTest.class, IncreasingTest.class, IncreasingSequenceTest.class,
		IncreasingTerraceTest.class, ProperPlateauTest.class })
public class Suite {

}
