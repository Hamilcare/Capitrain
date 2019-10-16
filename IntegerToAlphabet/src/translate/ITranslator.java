package translate;

import java.util.List;

public interface ITranslator {

	public List<Integer> getTextToTranslate();
	
	public String getTranslatedText();
	
	public void translate();
}
