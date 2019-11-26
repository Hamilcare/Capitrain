package main.java.automaton;

import main.java.accumulators.IAccumulator;
import main.java.aggregators.IAggregator;
import main.java.features.IFeature;
import main.java.states.IState;
import main.java.translation.ITranslator;

public class Automaton implements IAutomaton {

	public static final Automaton AUTOMATON = new Automaton();
	public static final int UNDEFINEDGuard = -1;

	IFeature feature;
	IAggregator aggregator;

	IAccumulator ACCD;// = new AccumulatorD();
	IAccumulator ACCC;// = new AccumulatorC();
	IAccumulator ACCR;// = new AccumulatorR();

	ITranslator translator;

	int inputSequenceLength;
	IState currentState;
	int currentXiPosition = 0;

	int meilleurStart = UNDEFINEDGuard;
	int meilleurEnd = UNDEFINEDGuard;

	int bufferMeilleurStart = UNDEFINEDGuard;
	int bufferMeilleurEnd = UNDEFINEDGuard;

	@Override
	public IFeature getFeature() {
		return feature;
	}

	@Override
	public IAggregator getAggregator() {
		return aggregator;
	}

	@Override
	public int getCurrentXiPosition() {
		return AUTOMATON.currentXiPosition;
	}

	@Override
	public IAccumulator getAccumulatorD() {

		return ACCD;
	}

	@Override
	public IAccumulator getAccumulatorC() {
		return ACCC;
	}

	@Override
	public IAccumulator getAccumulatorR() {
		return ACCR;
	}

	@Override
	public int getInputSequenceLength() {
		return inputSequenceLength;
	}

	@Override
	public IState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(IState newState) {
		AUTOMATON.currentState = newState;
		AUTOMATON.currentXiPosition++;
	}

	@Override
	public void setInputSequenceLenght(int lenght) {
		AUTOMATON.inputSequenceLength = lenght;
	}

	@Override
	public void setFeature(IFeature f) {
		AUTOMATON.feature = f;
	}

	@Override
	public void setAggregator(IAggregator a) {
		AUTOMATON.aggregator = a;
	}

	@Override
	public int getResult() {
		int start;
		int end;

		int result = AUTOMATON.aggregator.apply(AUTOMATON.ACCR.getCurrentValue(), AUTOMATON.ACCC.getCurrentValue());
		if (result == AUTOMATON.ACCR.getCurrentValue()) {
			start = AUTOMATON.ACCR.getStartXi();
			end = AUTOMATON.ACCR.getEndXi();
		} else {
			start = AUTOMATON.ACCC.getStartXi();
			end = AUTOMATON.ACCC.getEndXi();
		}

		System.out.println("start: " + start + ", end: " + end);

		return AUTOMATON.aggregator.apply(AUTOMATON.ACCR.getCurrentValue(), AUTOMATON.ACCC.getCurrentValue());
	}

	@Override
	public ITranslator getTranslator() {
		return this.translator;
	}

	@Override
	public void setTranslator(ITranslator translator) {
		this.translator = translator;
	}

}
