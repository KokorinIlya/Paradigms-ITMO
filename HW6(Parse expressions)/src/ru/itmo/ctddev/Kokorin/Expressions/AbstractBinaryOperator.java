package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Ilya Kokorin on 20.03.2017.
 */
public abstract class AbstractBinaryOperator implements TripleExpression {
    private TripleExpression first, second;

    public AbstractBinaryOperator(TripleExpression first, TripleExpression second){
        this.first = first;
        this.second = second;
    }

    public int evaluate(int x, int y, int z) {
        return operation(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    abstract protected int operation(int firstOperand, int secondOperand);
}
