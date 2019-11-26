package main.java.translation;

import main.java.alphabet.Alphabet;

public interface ITranslator {

	Alphabet getNextInput();

	int getInputAtIndex(int index);

	int getInputSequenceLength();

}