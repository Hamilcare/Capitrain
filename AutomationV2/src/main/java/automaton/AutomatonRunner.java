package automaton;

import alphabet.Alphabet;
import translation.ITranslator;

public class AutomatonRunner {
    private IAutomaton automaton;

    public AutomatonRunner(IAutomaton automaton){
        this.automaton = automaton;
    }

    public AutomatonResult run(){
        this.automaton.setInputSequenceLenght(this.automaton.getTranslator().getTextToTranslate().size());

        for (int i = 0; i < this.automaton.getTranslator().getTranslatedText().length(); i++) {
            this.automaton.applyNextInput(Alphabet.asEnum(this.automaton.getTranslator().getTranslatedText().charAt(i)));
        }
        return this.automaton.getResult();
    }
}
