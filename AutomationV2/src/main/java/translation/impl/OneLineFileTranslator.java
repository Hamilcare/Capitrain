package translation.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import translation.AbstractFileReader;

public class OneLineFileTranslator extends AbstractFileReader {

	public OneLineFileTranslator(String path) throws IOException {
		super(path);
	}

	@Override
	protected void prepareFileReader() throws IOException {
		br = Files.newBufferedReader(Paths.get(this.pathToFile));
		int i;
		while ((i = br.read()) != -1) {
			rawInput.add(Character.getNumericValue((char) i));
		}
	}

}
