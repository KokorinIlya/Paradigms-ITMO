/**
 * Created by Илья Кокорин on 21.03.2017.
 */

import ru.itmo.ctddev.Kokorin.Expressions.*;

public class ExpressionTest {
    public static void main(String args[]){
        int x = Integer.parseInt(args[0]);
        Add newExpression = new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),
                                new Variable("x")
                        ),
                        new Multiply(
                                new Variable("x"),
                                new Const(2)
                        )
                ),
                new Const(1)
        );
        System.out.println(newExpression.evaluate(x));
    }
}
