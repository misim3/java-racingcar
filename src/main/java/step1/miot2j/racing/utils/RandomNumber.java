package step1.miot2j.racing.utils;

import java.util.Random;

public class RandomNumber {

    public static int DISTANCE_CONDITION = 10;

    public static int makeOneRandomNumber() {
        Random random = new Random();
        return random.nextInt(DISTANCE_CONDITION);
    }

}
