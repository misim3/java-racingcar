package step1.miot2j.calculator;

import static step1.miot2j.calculator.ExceptionMessage.IS_NOT_MATH_EXPRESSION_MESSAGE;

import java.util.Arrays;

public enum MathSymbol {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*");

    private final String mathSymbol;

    MathSymbol(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public static MathSymbol findValidatedSymbol(String operator) {
        return Arrays.stream(MathSymbol.values())
            .filter(v -> v.getMathSymbol().equals(operator))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(String.format("잘못 된 연산자입니다.")));
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public double operate(double firstNumber, double secondNumber) {
        if (PLUS.getMathSymbol() == this.mathSymbol) {
            return firstNumber + secondNumber;
        }
        if (MINUS.getMathSymbol() == this.mathSymbol) {
            return firstNumber - secondNumber;
        }
        if (DIVIDE.getMathSymbol() == this.mathSymbol) {
            return firstNumber / secondNumber;
        }
        if (MULTIPLE.getMathSymbol() == this.mathSymbol) {
            return firstNumber * secondNumber;
        }
        throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
    }
}
