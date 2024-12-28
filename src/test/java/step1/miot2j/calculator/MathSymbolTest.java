package step1.miot2j.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MathSymbolTest {

    @Test
    void enumTest() {

        Assertions.assertThat(MathSymbol.PLUS.getMathSymbol()).isEqualTo("+");

    }

}
