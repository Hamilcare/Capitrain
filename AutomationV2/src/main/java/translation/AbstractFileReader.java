package translation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import alphabet.Alphabet;

public abstract class AbstractFileReader implements ITranslator {
	protected String pathToFile;
	protected int previousValue;
	protected BufferedReader br;
	protected List<Alphabet> translatedInput;
	protected List<Integer> rawInput;
	int currentIndex;

	public AbstractFileReader(String path) throws IOException {
		this.pathToFile = path;
		this.translatedInput = new LinkedList<>();
		this.rawInput = new ArrayList<>();
		currentIndex = 0;
		prepareFileReader();
		translate();

	}

	public void translate() {

		for (int i = 0; i < rawInput.size() - 1; i++) {
			Integer currentChar = rawInput.get(i);
			Integer nextChar = rawInput.get(i + 1);
			if (currentChar < nextChar) {
				translatedInput.add(Alphabet.MORE);
			} else if (currentChar > nextChar) {
				translatedInput.add(Alphabet.LESS);
			} else {
				translatedInput.add(Alphabet.EQUALS);
			}
		}
	}

	public Alphabet getNextInput() {
		Alphabet resul = translatedInput.get(currentIndex);
		currentIndex++;
		return resul;
	}

	public int getInputAtIndex(int index) {

		return rawInput.get(index);
	}

	public int getInputSequenceLength() {
		return rawInput.size();
	}

	protected abstract void prepareFileReader() throws IOException;
}
