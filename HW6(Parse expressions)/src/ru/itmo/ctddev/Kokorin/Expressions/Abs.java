package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class Abs extends AbstractUnaryOperator {

    public Abs(TripleExpression expression){
        super(expression);
    }

    public int operation(int value){
        return Math.abs(value);
    }
}
