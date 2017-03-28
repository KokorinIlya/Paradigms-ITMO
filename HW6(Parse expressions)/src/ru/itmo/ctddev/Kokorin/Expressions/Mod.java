package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class Mod extends AbstractBinaryOperator {
    public Mod(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int operation(int a, int b) {
        return a % b;
    }
}
