package translation;

import java.util.ArrayList;
import java.util.List;

import alphabets.InputAlphabet;

public class Translate implements ITranslator {

	List<Integer> textToTranslate;
	StringBuffer translatedText;

	public Translate() {
		textToTranslate = new ArrayList<>();
		translatedText = new StringBuffer();
	}

	public Translate(List<Integer> textToTranslate) {
		this.textToTranslate = textToTranslate;
		translatedText = new StringBuffer(textToTranslate.size());
	}

	@Override
	public List<Integer> getTextToTranslate() {
		return textToTranslate;
	}

	@Override
	public String getTranslatedText() {
		return translatedText.toString();

	}

	@Override
	public void translate() {
		for (int i = 0; i < textToTranslate.size() - 1; i++) {
			Integer currentChar = textToTranslate.get(i);
			Integer nextChar = textToTranslate.get(i + 1);
			if (currentChar < nextChar) {
				translatedText.append(InputAlphabet.LESS);
			} else if (currentChar > nextChar) {
				translatedText.append(InputAlphabet.MORE);
			} else {
				translatedText.append(InputAlphabet.EQUALS);
			}
		}
	}

}