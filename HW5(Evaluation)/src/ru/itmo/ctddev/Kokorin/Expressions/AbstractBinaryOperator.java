package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Ilya Kokorin on 20.03.2017.
 */
public abstract class AbstractBinaryOperator implements ExpressionAll{
    private ExpressionAll first, second;

    public AbstractBinaryOperator(ExpressionAll first, ExpressionAll second){
        this.first = first;
        this.second = second;
    }

    public int evaluate(int x) {
        return operation(first.evaluate(x), second.evaluate(x));
    }

    public double evaluate(double x) {
        return operation(first.evaluate(x), second.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return operation(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    abstract protected int operation(int firstOperand, int secondOperand);

    abstract protected double operation(double firstOperand, double SecondOperand);
}
