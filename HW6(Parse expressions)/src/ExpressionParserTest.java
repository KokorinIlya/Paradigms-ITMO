/**
 * Created by Илья Кокорин on 28.03.2017.
 */

import ru.itmo.ctddev.Kokorin.Expressions.TripleExpression;
import ru.itmo.ctddev.Kokorin.ParseExpressions.ExpressionParser;

public class ExpressionParserTest {
    public static void main(String[] args){
        String expression = args[0];
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        int z = Integer.parseInt(args[3]);
        ExpressionParser myParser = new ExpressionParser();
        TripleExpression myExpression = myParser.parse(expression);
        System.out.println(myExpression.evaluate(x, y, z));
    }
}
