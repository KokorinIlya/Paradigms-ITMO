package ru.itmo.ctddev.Kokorin.ParseExpressions;
import ru.itmo.ctddev.Kokorin.Expressions.*;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public interface Parser {
    TripleExpression parse(String expression);
}
