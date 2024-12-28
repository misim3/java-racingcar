package step1.miot2j.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTest() {

        double first = 3;
        double second = 4;
        assertThat(calculator.calculate(first, "+", second)).isEqualTo(7);

    }

    @Test
    void subtractionTest() {

        double first = 3;
        double second = 4;
        assertThat(calculator.calculate(first, "-", second)).isEqualTo(-1);

    }

    @Test
    void multiplicationTest() {

        double first = 3;
        double second = 4;
        assertThat(calculator.calculate(first, "/", second)).isEqualTo(0.75);

    }

    @Test
    void divisionTest() {

        double first = 3;
        double second = 4;
        assertThat(calculator.calculate(first, "*", second)).isEqualTo(12);

    }
}
