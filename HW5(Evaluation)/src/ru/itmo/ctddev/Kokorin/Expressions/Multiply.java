package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Илья Кокорин on 21.03.2017.
 */
public class Multiply extends AbstractBinaryOperator{
    public Multiply(ExpressionAll firstExpression, ExpressionAll secondExpression){
        super(firstExpression, secondExpression);
    }

    protected int operation(int firstOperand, int secondOperand){
        return firstOperand * secondOperand;
    }

    protected double operation(double firstOperand, double secondOperand){
        return firstOperand * secondOperand;
    }
}
