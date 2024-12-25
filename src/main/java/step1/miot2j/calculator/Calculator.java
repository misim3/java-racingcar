package step1.miot2j.calculator;

import static step1.miot2j.calculator.view.Input.inputMathExpression;
import static step1.miot2j.calculator.view.Output.outputStartMessage;
import static step1.miot2j.calculator.view.Output.resultOutput;

import java.util.List;

public class Calculator {

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
        List<String> slicedMathExpressionList = convertSplitExpressionArrayToList(
            slicedMathExpression);
        return slicedMathExpressionList;
    }

    private void validate(String mathExpression) {
        IsInputNull(mathExpression);
        IsNotMathExpression(mathExpression);
        IsTheEndNotNumber(mathExpression);
    }
}
