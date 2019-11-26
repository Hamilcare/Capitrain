package main.java.translation.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.translation.AbstractFileReader;

public class OneLineFileTranslator extends AbstractFileReader {

	public OneLineFileTranslator(String path) throws IOException {
		super(path);
	}

	@Override
	protected void prepareFileReader() throws IOException {
		br = Files.newBufferedReader(Paths.get(this.pathToFile));
		while (br.ready()) {
			rawInput.add(br.read());
		}
	}

}
