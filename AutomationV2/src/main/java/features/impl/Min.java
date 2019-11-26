package features.impl;

import automaton.Automaton;
import features.AbstractFeature;
import application.Main;

public class Min extends AbstractFeature {
    @Override
    public String getName() {
        return "MIN";
    }

    @Override
    public int getNeutral() {
        return Integer.MAX_VALUE;
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
        return Math.min(a, b);
    }

    @Override
    public int getValue() {
        return Automaton.AUTOMATON.getTranslator().getTextToTranslate().get(Automaton.AUTOMATON.getCurrentXiPosition());
    }
}
