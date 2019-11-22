package transitions;

import alphabet.Alphabet;
import semantic.letter.ISemanticLetter;
import states.IState;

public abstract class AbstractTransition implements ITransition {

	Alphabet letter;
	ISemanticLetter semantic;
	IState target;

	public AbstractTransition(Alphabet letter, ISemanticLetter semantic, IState target) {
		super();
		this.letter = letter;
		this.semantic = semantic;
		this.target = target;
	}

	@Override
	public Alphabet getLetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISemanticLetter getSemantic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IState getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

}
