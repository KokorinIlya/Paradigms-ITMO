package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class Square extends AbstractUnaryOperator {

    public Square(TripleExpression expression){
        super(expression);
    }

    public int operation(int value){
        return value * value;
    }
}
