package ru.itmo.ctddev.Kokorin.Expressions;

/**
 * Created by Ilya Kokorin on 20.03.2017.
 */
public class Variable implements ExpressionAll{
    private String name;

    public Variable(String name){
        this.name = name;
    }

    public int evaluate(int x){
        return x;
    }

    public double evaluate(double x){
        return x;
    }

    public int evaluate(int x, int y, int z){
        if (name.equals("x")){
            return x;
        } else if (name.equals("y")){
            return y;
        }
        return z;
    }
}
