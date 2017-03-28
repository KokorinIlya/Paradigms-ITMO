package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 21.03.2017.
 */
public class Divide extends AbstractBinaryOperator {
    public Divide (TripleExpression firstExpression, TripleExpression secondExpression){
        super(firstExpression, secondExpression);
    }

    protected int operation(int firstOperand, int secondOperand){
        return firstOperand / secondOperand;
    }
}
