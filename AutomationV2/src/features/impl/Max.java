package features.impl;

import automaton.Automaton;
import features.AbstractFeature;
import main.Main;

public class Max extends AbstractFeature {
    @Override
    public String getName() {
        return "MAX";
    }

    @Override
    public int getNeutral() {
        return Integer.MIN_VALUE;
    }

    @Override
    public int getMin() {
        return Integer.MIN_VALUE;
    }

    @Override
    public int getMax() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int apply(int a, int b) {
        return Math.max(a, b);
    }

    @Override
    public int getValue() {
        return Main.translator.getTextToTranslate().get(Automaton.AUTOMATON.getCurrentXiPosition());
    }
}
