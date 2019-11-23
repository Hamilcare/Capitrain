package features.impl;

import automaton.Automaton;
import features.AbstractFeature;
import main.Main;

public class Range extends AbstractFeature {
    @Override
    public String getName() {
        return "RANGE";
    }

    @Override
    public int getNeutral() {
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int apply(int a, int b) {
        //TODO: return ??
        return 0;
    }

    @Override
    public int getValue() {
        return Main.translator.getTextToTranslate().get(Automaton.AUTOMATON.getCurrentXiPosition());
    }
}
