package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Ilya Kokorin on 20.03.2017.
 */
public class Const implements TripleExpression {
    private double value;

    public Const(int value){
        this.value = value;
    }

    public Const(double value){
        this.value = value;
    }

    public int evaluate(int x, int y, int z){
        return (int) value;
    }
}
