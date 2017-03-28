package ru.itmo.ctddev.Kokorin.ParseExpressions;

import ru.itmo.ctddev.Kokorin.Expressions.*;

/**
 * Created by Илья Кокорин on 28.03.2017.
 */
public class ExpressionParser implements Parser {
    //парсинг спускается от минимального приоритета к максимальному shifts -> addSub -> mulDiv -> unary
    //у всех операций левая ассоциативность, так что получать токены будем слева направо
    private String expression;
    private int index;
    private int constValue;
    private String variableName;

    private enum AllTokens {constant, add, sub, mul, div, mod, shiftLeft, shiftRight, square, abs, leftBracket, rightBracket, variable}

    private AllTokens currentToken;

    /*private char getChar() {
        if (index < expression.length()) {
            char result = expression.charAt(index);
            index++;
            return result;
        }
        return '#';
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(expression.charAt(index))) {

        }
    }

    private void getNextToken() {
        skipWhitespace();
        char currentChar = getChar();
        if (Character.isDigit(currentChar)) {
            constValue = 0;
            while (Character.isDigit(currentChar)){
                constValue *= 10;
                int x = (int)(currentChar - '0');
                constValue += x;
                currentChar = getChar();
            }
            index--;
            currentToken = AllTokens.constant;
        } else {

        }
        skipWhitespace();
    }*/

    private char getNextChar() {
        if (index < expression.length()) {
            char ret =  expression.charAt(index);
            index++;
            return ret;
        } else {
            return '#';
        }
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(getNextChar())) {

        }
        index--;
    }

    private void getNextToken() {
        skipWhitespace();
        char ch = getNextChar();
        if (Character.isDigit(ch)) {
            StringBuilder str = new StringBuilder();
            while (Character.isDigit(ch)) {
                str.append(ch);
                ch = getNextChar();
            }
            index--;
            constValue = Integer.parseUnsignedInt(str.toString());
            currentToken = AllTokens.constant;
        } else if (ch == '+') {
            currentToken = AllTokens.add;
        } else if (ch == '-') {
            currentToken = AllTokens.sub;
        } else if (ch == '*') {
            currentToken = AllTokens.mul;
        } else if (ch == '/') {
            currentToken = AllTokens.div;
        } else if (ch == '(') {
            currentToken = AllTokens.leftBracket;
        } else if (ch == ')') {
            currentToken = AllTokens.rightBracket;
        } else if (ch == 'x' || ch == 'y' || ch == 'z') {
            currentToken = AllTokens.variable;
            variableName = Character.toString(ch);
        } else if(index < expression.length()) {
            if (expression.substring(index - 1, index + 2).equals("mod")) {
                currentToken = AllTokens.mod;
                index += 2;
            } else if (expression.substring(index - 1, index + 1).equals("<<")) {
                currentToken = AllTokens.shiftLeft;
                index += 1;
            } else if (expression.substring(index - 1, index + 1).equals(">>")) {
                currentToken = AllTokens.shiftRight;
                index += 1;
            } else if (expression.substring(index - 1, index + 2).equals("abs")) {
                currentToken = AllTokens.abs;
                index += 2;
            } else if (expression.substring(index - 1, index + 5).equals("square")) {
                currentToken = AllTokens.square;
                index += 5;
            }
        }
        skipWhitespace();

    }



    private TripleExpression unary(){
        getNextToken();
        TripleExpression operand = new Const(0);
        switch (currentToken) {
            case constant: {
                operand = new Const(constValue);
                getNextToken();
                break;
            }
            case sub: {
                operand = new UnaryMinus(unary());
                break;
            }
            case variable: {
                operand = new Variable(variableName);
                getNextToken();
                break;
            }
            case square: {
                operand = new Square(unary());
                break;
            }
            case abs: {
                operand = new Abs(unary());
                break;
            }
            case leftBracket: { //я очень надеюсь, что скобочная последовательность правильная и следующим после вызова shiift символом будет rightBracket
                operand = shift();
                getNextToken();
                break;
            }
        }
        return operand;
    }

    private TripleExpression mulDivMod(){
        TripleExpression operand = unary();
        while (true) {
            switch (currentToken) {
                case mul: {
                    operand = new Multiply(operand, unary());
                    break;
                }
                case div: {
                    operand = new Divide(operand, unary());
                    break;
                }
                case mod: {
                    operand = new Mod(operand, unary());
                    break;
                }
                default: {
                    return operand;
                }
            }
        }
    }

    private TripleExpression addSub(){
        TripleExpression operand = mulDivMod();
        while (true) {
            switch (currentToken) {
                case add: {
                    operand = new Add(operand, mulDivMod());
                    break;
                }
                case sub: {
                    operand = new Subtract(operand, mulDivMod());
                    break;
                }
                default: {
                    return operand;
                }
            }
        }
    }

    private TripleExpression shift() {
        TripleExpression operand = addSub();
        while (true) {
            switch (currentToken){
                case shiftLeft: {
                    operand = new ShiftLeft(operand, addSub());
                    break;
                }
                case shiftRight: {
                    operand = new ShiftRight(operand, addSub());
                    break;
                }
                default:{
                    return operand;
                }
            }
        }
    }

    public TripleExpression parse(String expression) {
        this.expression = expression;
        index = 0;
        return shift(); //вызов метода парсинга по минимальному приоритету
    }
}