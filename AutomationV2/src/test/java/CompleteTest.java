import aggregators.IAggregator;
import aggregators.impl.Max;
import aggregators.impl.Min;
import automaton.*;
import features.IFeature;
import features.impl.Width;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import translation.ITranslator;
import translation.Translate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CompleteTest {
    private IAggregator aggregator;
    private IFeature feature;
    private String patternFilePath;
    private String dataFilePath;
    private AutomatonResult expectedResult;

    @Parameterized.Parameters
    public static Collection dataSet(){
        return Arrays.asList(new Object[][]{
                { new Max(), new Width(), "./input/peak.csv", "./input/exemple", new AutomatonResult(6, 11, 16) },
                { new Min(), new Width(), "./input/peak.csv", "./input/exemple", new AutomatonResult(5, 4, 8) },
                { new Min(), new Width(), "./input/peak.csv", "./input/exemple", new AutomatonResult(5, 4, 8) },
                { new Min(), new Width(), "./input/peak.csv", "./input/exemple", new AutomatonResult(5, 4, 8) },
        });
    }

    public CompleteTest(IAggregator aggregator, IFeature feature, String patternFilePath, String dataFilePath, AutomatonResult expectedResult) {
        this.aggregator = aggregator;
        this.feature = feature;
        this.patternFilePath = patternFilePath;
        this.dataFilePath = dataFilePath;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testAutomaton() throws IOException{
        System.out.println(String.format("Testing with: %s %s %s %s", this.aggregator.getName(), this.feature.getName(), this.patternFilePath, this.dataFilePath));
        ITranslator translator = translateInput(this.dataFilePath);

        IAutomaton automaton = AutomatonBuilder.buildNewAutomaton(this.patternFilePath, this.feature, this.aggregator, translator);
        AutomatonRunner automatonRunner = new AutomatonRunner(automaton);
        AutomatonResult result = automatonRunner.run();

        Assert.assertEquals("Value", this.expectedResult.getValue(), result.getValue());
        Assert.assertEquals("Borne inf.", this.expectedResult.getX1(), result.getX1());
        Assert.assertEquals("Borne sup.", this.expectedResult.getX2(), result.getX2());

        Automaton.AUTOMATON = new Automaton();
    }

    private static ITranslator translateInput(String pathToData) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(pathToData)));
            System.out.println("Text contains " + content.length() + " characters");

            List<Integer> textToTranslate = new ArrayList<>(content.length());
            for (int i = 0; i < content.length(); i++) {
                textToTranslate.add(Character.getNumericValue(content.charAt(i)));
            }

            System.out.println("size array : " + textToTranslate.size());
            ITranslator translator = new Translate(textToTranslate);
            translator.translate();
            System.out.println("Translated");

            return translator;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
