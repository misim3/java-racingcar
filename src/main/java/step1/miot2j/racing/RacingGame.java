package step1.miot2j.racing;

import static step1.miot2j.racing.utils.RandomNumber.makeOneRandomNumber;
import static step1.miot2j.racing.view.Input.makeCarNames;
import static step1.miot2j.racing.view.Input.makeGameRepeatCount;
import static step1.miot2j.racing.view.Output.printInputCountMessage;
import static step1.miot2j.racing.view.Output.printNowDistance;
import static step1.miot2j.racing.view.Output.printResultMessage;
import static step1.miot2j.racing.view.Output.printStartMessage;
import static step1.miot2j.racing.view.Output.printWinMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static String SEPARATOR = ",";

    public void gameStart() {

        printStartMessage();
        String carNames = makeCarNames();
        printInputCountMessage();
        int count = makeGameRepeatCount();
        printResultMessage();

        String[] carNameArray = carNames.split(SEPARATOR);
        List<Car> carList = makeCarList(carNameArray);

        repeatMoveCars(count, carList);
        printWinMessage(findWinner(carList));

    }

    private List<Car> makeCarList(String[] carNameArray) {

        List<Car> carList = new ArrayList<>();

        for (String carName : carNameArray) {

            carList.add(new Car(carName));
        }

        return carList;

    }

    private void repeatMoveCars(int count, List<Car> carList) {

        for (int i = 0; i < count; i++) {

            moveCars(carList);

        }

    }

    private void moveCars(List<Car> carList) {

        for (int i = 0; i < carList.size(); i++) {

            carList.get(i).move(makeOneRandomNumber());

        }

        printNowDistance(carList);
    }

    private List<String> findWinner(List<Car> carList) {

        List<String> winnerList = new ArrayList<>();
        int winnerCondition = findWinnerCondition(carList);

        for (Car car : carList) {

            if (car.getMoveCount() == winnerCondition) {

                winnerList.add(car.getName());

            }

        }

        return winnerList;

    }

    private int findWinnerCondition(List<Car> carList) {

        int winnerCondition = 0;

        for (Car car : carList) {

            if (car.getMoveCount() >= winnerCondition) {

                winnerCondition = car.getMoveCount();

            }

        }

        return winnerCondition;

    }
}
