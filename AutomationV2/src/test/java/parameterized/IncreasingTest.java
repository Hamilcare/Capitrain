package parameterized;

import aggregators.IAggregator;
import aggregators.impl.Max;
import aggregators.impl.Min;
import automaton.AutomatonBuilder;
import automaton.AutomatonResult;
import automaton.AutomatonRunner;
import automaton.IAutomaton;
import features.IFeature;
import features.impl.Surface;
import features.impl.Width;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IncreasingTest {
    private IAggregator aggregator;
    private IFeature feature;
    private String patternFilePath;
    private String dataFilePath;
    private AutomatonResult expectedResult;

    @Parameterized.Parameters
    public static Collection dataSet() {
        return Arrays.asList(new Object[][] {
                { new Max(), new Surface(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", new AutomatonResult(10, 9, 9) },
                { new Max(), new features.impl.Max(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", new AutomatonResult(6, 9, 9) },
                { new Min(), new features.impl.Max(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", new AutomatonResult(3, 6, 6) },
                { new Min(), new features.impl.Min(), "./resources/pattern/increasing.csv", "./resources/input/catalogueExemples/increasing", new AutomatonResult(1, 6, 6) },
        });
    }

    public IncreasingTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath,
                    AutomatonResult expectedResult) {
        this.aggregator = aggregator;
        this.feature = feature;
        this.patternFilePath = patternFilePath;
        this.dataFilePath = dataFilePath;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testAutomaton() throws IOException {
        System.out.println(String.format("Testing with: %s %s %s %s", this.aggregator.getName(), this.feature.getName(),
                this.patternFilePath, this.dataFilePath));
        ITranslator translator = new OneLineFileTranslator(this.dataFilePath);

        IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(this.patternFilePath, this.feature, this.aggregator,
                translator);
        AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
        AutomatonResult result = automatonRunner.run();

        Assert.assertEquals("Value", this.expectedResult.getValue(), result.getValue());
        Assert.assertEquals("Borne inf.", this.expectedResult.getX1(), result.getX1());
        Assert.assertEquals("Borne sup.", this.expectedResult.getX2(), result.getX2());

    }
}
