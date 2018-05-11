package dao;

import common.Cache;
import common.Constants;
import entities.Pet;
import entities.templates.FoodTemplate;

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

    public static int getFoodBowlStock() {
        Integer stock = Cache.get(Constants.KEY_FOOD_BOWL_STOCK);
        return stock == null ? 0 : stock;
    }

    public static void updateFoodBowlStock(int stock) {
        Cache.put(Constants.KEY_FOOD_BOWL_STOCK, stock);
    }

    public static FoodTemplate getFoodInBowl() {
        Integer foodId = Cache.get(Constants.KEY_FOOD_IN_BOWL);
        if (foodId == null) {
            return null;
        }
        return FoodDAO.getFoodTemplateByFoodId(foodId);
    }
}
