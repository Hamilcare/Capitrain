import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import parameterized.IncreasingTest;
import parameterized.PeakTest;
import parameterized.PlateauTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({ PeakTest.class, IncreasingTest.class, PlateauTest.class })
public class Suite {

}
