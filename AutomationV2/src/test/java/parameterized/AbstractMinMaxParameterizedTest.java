package parameterized;

import static org.junit.Assert.assertEquals;
import static utils.Utils.NA;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import automaton.aggregators.IAggregator;
import automaton.impl.AutomatonBuilder;
import automaton.impl.AutomatonResult;
import automaton.impl.AutomatonRunner;
import automaton.IAutomaton;
import automaton.features.IFeature;
import translation.ITranslator;
import translation.impl.OneLineFileTranslator;

public class AbstractMinMaxParameterizedTest {
	private IAggregator aggregator;
	private IFeature feature;
	private String patternFilePath;
	private String dataFilePath;
	private List<AutomatonResult> expectedResult;

	public AbstractMinMaxParameterizedTest(IAggregator aggregator, IFeature feature, String patternFilePath,
			String dataFilePath, List<AutomatonResult> expectedResult) {
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
		List<AutomatonResult> result = automatonRunner.run();

		assertEquals("nbResult : ", this.expectedResult.size(), result.size());
		if (!result.isEmpty()) {
			assertEquals("Value", this.expectedResult.get(0).getValue(), result.get(0).getValue());
		}

		for (int i = 0; i < result.size(); i++) {
			AutomatonResult expected = this.expectedResult.get(i);
			AutomatonResult actual = result.get(i);
			assertEquals("Value", expected.getValue(), actual.getValue());
			if (expected.getX1() != NA) {
				assertEquals("start: ", expected.getX1(), actual.getX1());
				assertEquals("end: ", expected.getX2(), actual.getX2());
			}
		}

	}

}
