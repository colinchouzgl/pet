package common;

import java.util.Random;

/**
 * @author Zhou Guanliang
 * @since 2017/8/9
 */
public class Utils {
    public static boolean tossCoin(int possibility) {
        if (possibility >= 100) {
            return true;
        }
        if (possibility <= 0) {
            return false;
        }
        int result = getRandomNumber(0, 100);
        return result < possibility;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int safeAdd(int value, int offset) {
        value += offset;
        return value > Constants.MAX_VALUE ? Constants.MAX_VALUE : value;
    }

    public static int safeSub(int value, int offset) {
        value -= offset;
        return value < Constants.MIN_VALUE ? Constants.MIN_VALUE : value;
    }
}