package translation;

import java.util.ArrayList;
import java.util.List;

import alphabet.Alphabet;

public class Translate implements ITranslator {

	List<Integer> textToTranslate;
	String translatedText;

	public Translate() {
		textToTranslate = new ArrayList<>();

	}

	public Translate(List<Integer> textToTranslate) {
		this.textToTranslate = textToTranslate;

	}

	@Override
	public List<Integer> getTextToTranslate() {
		return textToTranslate;
	}

	@Override
	public String getTranslatedText() {
		return translatedText;

	}

	@Override
	public void translate() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < textToTranslate.size() - 1; i++) {
			Integer currentChar = textToTranslate.get(i);
			Integer nextChar = textToTranslate.get(i + 1);
			if (currentChar < nextChar) {
				sb.append(Alphabet.MORE.asString());
			} else if (currentChar > nextChar) {
				sb.append(Alphabet.LESS.asString());
			} else {
				sb.append(Alphabet.EQUALS.asString());
			}
		}
		translatedText = sb.toString();
	}

}
