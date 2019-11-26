import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import parameterized.IncreasingSequenceTest;
import parameterized.IncreasingTest;
import parameterized.PeakTest;
import parameterized.PlateauTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({ PeakTest.class, PlateauTest.class, IncreasingTest.class, IncreasingSequenceTest.class })
public class Suite {

}
