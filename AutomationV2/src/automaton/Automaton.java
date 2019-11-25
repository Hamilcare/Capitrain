package automaton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import accumulators.IAccumulator;
import aggregators.IAggregator;
import alphabet.Alphabet;
import features.IFeature;
import main.Main;
import states.IState;

public class Automaton implements IAutomaton {

	public static final Automaton AUTOMATON = new Automaton();
	IFeature feature;
	IAggregator aggregator;

	IAccumulator ACCD;// = new AccumulatorD();
	IAccumulator ACCC;// = new AccumulatorC();
	IAccumulator ACCR;// = new AccumulatorR();
	int inputSequenceLength;
	IState currentState;
	int currentXiPosition = 0;

	BlockingQueue<Alphabet> bq;

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
	public IState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(IState newState) {
		AUTOMATON.currentState = newState;
		AUTOMATON.currentXiPosition++;
//		System.out.print(AUTOMATON.currentState.getLabel());

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
		return AUTOMATON.aggregator.apply(AUTOMATON.ACCR.getCurrentValue(), AUTOMATON.ACCC.getCurrentValue());
	}

	@Override
	public void run() {
		while (bq.size() > 0 || Main.producerIsAlive) {
			List<Alphabet> nextInputs = new ArrayList<>(5);
			// Alphabet lettre = bq.take();
			// System.out.println("Je dépile " + lettre);
			synchronized (bq) {
//				bq.drainTo(nextInputs, nextInputs.size());
				bq.drainTo(nextInputs);
			}
			nextInputs.forEach(input -> this.applyNextInput(input));
			// this.applyNextInput(bq.take());
		}
	}

	@Override
	public void setQueue(BlockingQueue<Alphabet> q) {
		this.bq = q;
	}

}
