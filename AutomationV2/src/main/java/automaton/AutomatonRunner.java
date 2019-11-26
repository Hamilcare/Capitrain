package automaton;

import alphabet.Alphabet;
import translation.ITranslator;

public class AutomatonRunner {
    private IAutomaton automaton;

    public AutomatonRunner(IAutomaton automaton){
        this.automaton = automaton;
    }

    public Result run(ITranslator translator){
        this.automaton.setInputSequenceLenght(translator.getTextToTranslate().size());

        for (int i = 0; i < translator.getTranslatedText().length(); i++) {
            this.automaton.applyNextInput(Alphabet.asEnum(translator.getTranslatedText().charAt(i)));
        }
        return new Result(this.automaton.getResult());
    }

    public class Result{
        private Result(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private int value;
    }
}
