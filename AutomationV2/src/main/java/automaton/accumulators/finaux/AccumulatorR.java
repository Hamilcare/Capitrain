package automaton.accumulators.finaux;

import java.util.ArrayList;
import java.util.List;

import automaton.IAutomaton;

public class AccumulatorR implements IAccumulatorFinal {

	List<Integer> startXi;
	List<Integer> endXi;
	int currentValue;
	IAutomaton automaton;

	public AccumulatorR(IAutomaton automaton) {
		this.automaton = automaton;
		startXi = new ArrayList<>();
		endXi = new ArrayList<>();
		this.setToInitValue();
	}

	@Override
	public void updateValue(int newValue) {
		currentValue = newValue;
	}

	@Override
	public void setStartXi(int position) {
		startXi.clear();
		startXi.add(position);
	}

	@Override
	public void setEndXi(int position) {
		endXi.clear();
		endXi.add(position);
	}

	@Override
	public void addStartXi(int position) {
		startXi.add(position);
	}

	@Override
	public void addEndXi(int position) {
		endXi.add(position);
	}

	@Override
	public List<Integer> getStartXi() {
		return startXi;
	}

	@Override
	public List<Integer> getEndXi() {
		return endXi;
	}

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}

	@Override
	public void setToInitValue() {
		this.currentValue = automaton.getAggregator().getDefault();
		this.startXi.clear();
		this.endXi.clear();

	}

	@Override
	public int getCurrentValue() {
		return currentValue;
	}

}
