package translation;

import translation.impl.MultipleLineFileTranslator;
import translation.impl.OneLineFileTranslator;

import java.io.IOException;

public class TranslatorFactory {
    public static ITranslator createTranslatorFromName(String path, String name) throws IOException {
        switch (name.toUpperCase()){
            case "SINGLE":
                return new OneLineFileTranslator(path);
            case "MULTIPLE":
                return new MultipleLineFileTranslator(path);
            default:
                return null;
        }
    }
}
