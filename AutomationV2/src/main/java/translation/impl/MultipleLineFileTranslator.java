package translation.impl;


import translation.AbstractFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MultipleLineFileTranslator extends AbstractFileReader {

    public MultipleLineFileTranslator(String path) throws IOException {
        super(path);
    }

    @Override
    protected void prepareFileReader() throws IOException {
        br = Files.newBufferedReader(Paths.get(this.pathToFile));
        while (br.ready()){
            rawInput.add(Integer.parseInt(br.readLine()));
        }
    }
}
