package step1.miot2j.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @Test
    @DisplayName("난수가 4 이상일 때 거리 증가")
    public void moveTest() {
        // given
        Car car = new Car("aaa");
        int randomNumber = 4;
        int moveCount = car.getMoveCount();

        // when
        car.move(randomNumber);

        // then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);

    }


    @Test
    @DisplayName("난수가 4 미만일 때 거리 변화 없음")
    public void notMoveTest() {
        // given
        Car car = new Car("aaa");
        int randomNumber = 2;
        int moveCount = car.getMoveCount();

        // when
        car.move(randomNumber);

        // then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(moveCount);

    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("난수가 4 미만일 때 거리 변화 없음. 5 이상인 경우 변화 있음.")
    public void 난수의조건을모두체크(int randomNumber, int changeMoveCount) {

        // given
        Car car = new Car("aaa");

        // when
        car.move(randomNumber);

        // then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(changeMoveCount);

    }
}
