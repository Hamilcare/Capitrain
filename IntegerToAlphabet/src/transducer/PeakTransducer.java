package transducer;

import alphabet.Alphabet;

public class PeakTransducer {
    private State state = State.S;

    public Output compute(char letter){
        switch (state){
            case S:
                if(letter == Alphabet.LESS || letter == Alphabet.EQUALS){
                    state = State.S;
                    return Output.OUT;
                }
                else {
                    state = State.R;
                    return Output.OUT;
                }
            case R:
                if(letter == Alphabet.MORE || letter == Alphabet.EQUALS){
                    state = State.R;
                    return Output.MAYBEB;
                }
                else{
                    state = State.T;
                    return Output.FOUND;
                }
            case T:
                if(letter == Alphabet.LESS){
                    state = State.T;
                    return Output.IN;
                }
                else if(letter == Alphabet.EQUALS){
                    state = State.T;
                    return Output.MAYBEA;
                }
                else{
                    state = State.R;
                    return Output.OUTA;
                }
        }
        return null;
    }
}

