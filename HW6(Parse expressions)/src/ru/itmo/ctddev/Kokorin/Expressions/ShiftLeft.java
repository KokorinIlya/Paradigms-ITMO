package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class ShiftLeft extends AbstractBinaryOperator {
    public ShiftLeft(TripleExpression firstExpression, TripleExpression secondExpression){
        super(firstExpression, secondExpression);
    }

    protected int operation(int firstOperand, int secondOperand){
        return firstOperand << secondOperand;
    }
}
