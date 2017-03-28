package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public abstract class AbstractUnaryOperator implements TripleExpression{
    private TripleExpression expression;

    public AbstractUnaryOperator(TripleExpression expression){
        this.expression = expression;
    }

    public int evaluate(int x, int y, int z){
        return operation(expression.evaluate(x, y, z));
    }

    abstract protected int operation(int x);
}
