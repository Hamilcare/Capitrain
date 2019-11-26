package translation;

import alphabet.Alphabet;

public interface ITranslator {

	Alphabet getNextInput();

	int getInputAtIndex(int index);

	int getInputSequenceLength();

}