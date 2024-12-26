package step1.miot2j.calculator;

import static step1.miot2j.calculator.ExceptionMessage.DO_NOT_INPUT_NULL_MESSAGE;
import static step1.miot2j.calculator.ExceptionMessage.IS_NOT_MATH_EXPRESSION_MESSAGE;
import static step1.miot2j.calculator.ExceptionMessage.THE_END_IS_NOT_NUMBER_MESSAGE;
import static step1.miot2j.calculator.view.Input.inputMathExpression;
import static step1.miot2j.calculator.view.Output.outputStartMessage;
import static step1.miot2j.calculator.view.Output.resultOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private static final String IS_NOT_MATH_EXPRESSION = "[^0-9+\\-*/]";
    private static final String THE_END_IS_NOT_NUMBER = "[0-9]*$";
    private static final String MAKE_EMPTY = "";

    public void printResult() {
        Calculator calculator = new Calculator();
        outputStartMessage();
        resultOutput(calculator.makeResult(makeSlicedMathExpression()));
    }

    private double makeResult(List<String> mathExpression) {

    }

    private List<String> makeSlicedMathExpression() {
        String enteredMathExpression = inputMathExpression();
        validate(enteredMathExpression);
        String[] slicedMathExpression = sliceMathExpression(enteredMathExpression);
        List<String> slicedMathExpressionList = convertSplitExpressionArrayToList(slicedMathExpression);
        return slicedMathExpressionList;
    }

    private void validate(String mathExpression) {
        isInputNull(mathExpression);
        isNotMathExpression(mathExpression);
        isTheEndNotNumber(mathExpression);
    }

    private void isInputNull(String mathExpression) {
        if (mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(DO_NOT_INPUT_NULL_MESSAGE);
        }
    }

    private void isNotMathExpression(String mathExpression) {
        if (Pattern.matches(IS_NOT_MATH_EXPRESSION, mathExpression)) {
            throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
        }
    }

    private void isTheEndNotNumber(String mathExpression) {
        if (Pattern.matches(THE_END_IS_NOT_NUMBER, mathExpression)) {
            throw new IllegalArgumentException(THE_END_IS_NOT_NUMBER_MESSAGE);
        }
    }

    private String[] sliceMathExpression(String mathExpression) {
        return mathExpression.split("");
    }

    private List<String> convertSplitExpressionArrayToList(String[] splitMathExpression) {
        List<String> mathExpressions = new ArrayList<>();
        String integerOfMathExpression = MAKE_EMPTY;

        for (String mathSymbol : splitMathExpression) {
            if (isNotNumberPattern(mathSymbol)) {
                mathExpressions.add(integerOfMathExpression);
                mathExpressions.add(mathSymbol);
                integerOfMathExpression = MAKE_EMPTY;
                continue;
            }
            integerOfMathExpression = integerOfMathExpression.concat(mathSymbol);
        }
        if (haveIntegerExpression(integerOfMathExpression)) {
            mathExpressions.add(integerOfMathExpression);
        }
        return mathExpressions;
    }
}
