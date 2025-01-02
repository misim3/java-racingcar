package step1.miot2j.racing;

public class RacingGame {

    public static String SEPARATOR = ",";

    public void gameStart() {

        printStartMessage();
        String carNames = makeCarNames();
        printInputCountMessage();
        printResultMessage();

        String[] carNameArray = carNames.split(SEPARATOR);
        List<Car> carList = makeCarList(carNameArray);

        repeatMoveCars(count, carList);
        printWinMessage(findWinner(carList));
        
    }

}
