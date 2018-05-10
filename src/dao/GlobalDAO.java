package dao;

import common.Cache;
import common.Constants;
import entities.Pet;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class GlobalDAO {
    public static Pet getPet() {
        return Cache.get(Constants.KEY_PET);
    }

    public static void updatePet(Pet pet) {
        Cache.put(Constants.KEY_PET, pet);
    }

    public static int getMoney() {
        Integer money = Cache.get(Constants.KEY_MONEY);
        return money == null ? 0 : money;
    }

    public static void updateMoney(int money) {
        Cache.put(Constants.KEY_MONEY, money);
    }
}
