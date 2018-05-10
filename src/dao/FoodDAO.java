package dao;

import common.Cache;
import common.Constants;
import entities.items.Food;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class FoodDAO {
    public static List<Food> getFoods() {
        return Cache.get(Constants.KEY_FOODS);
    }

    public static Food getFood(int foodId) {
        List<Food> foods = getFoods();
        if (CollectionUtils.isEmpty(foods)) {
            return null;
        }
        for (Food food : foods) {
            if (food.getId() == foodId) {
                return food;
            }
        }
        return null;
    }

    public static List<Food> getOwnedFoods() {
        return Cache.get(Constants.KEY_OWNED_FOODS);
    }

    public static Food getOwnedFood(int foodId) {
        List<Food> ownedFoods = getOwnedFoods();
        if (CollectionUtils.isEmpty(ownedFoods)) {
            return null;
        }
        for (Food food : ownedFoods) {
            if (food.getId() == foodId) {
                return food;
            }
        }
        return null;
    }

    public static boolean updateOwnedFood(Food newData) {
        List<Food> ownedFoods = getOwnedFoods();
        if (CollectionUtils.isEmpty(ownedFoods)) {
            return false;
        }
        for (Food food : ownedFoods) {
            if (food.getId() == newData.getId()) {
                ownedFoods.remove(food);
                ownedFoods.add(newData);
                return true;
            }
        }
        return false;
    }
}
