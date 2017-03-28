package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 21.03.2017.
 */
public class Subtract extends AbstractBinaryOperator {
    public Subtract(TripleExpression firstExpression, TripleExpression secondExpression){
        super(firstExpression, secondExpression);
    }


    protected int operation(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
