package semantic.letter;

import automaton.IAutomaton;

public abstract class AbstractSemanticLetter implements ISemanticLetter {

	IAutomaton automaton;

	public AbstractSemanticLetter(IAutomaton automaton) {
		this.automaton = automaton;
	}

	@Override
	public IAutomaton getAutomaton() {
		return automaton;
	}

}
