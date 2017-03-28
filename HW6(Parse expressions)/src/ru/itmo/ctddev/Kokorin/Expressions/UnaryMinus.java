package ru.itmo.ctddev.Kokorin.Expressions;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class UnaryMinus extends AbstractUnaryOperator {

    public UnaryMinus(TripleExpression expression){
        super(expression);
    }

    public int operation(int value){
        return -1 * value;
    }

}
