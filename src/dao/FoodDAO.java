package dao;

import common.Cache;
import common.Constants;
import entities.items.consumables.Food;
import entities.templates.FoodTemplate;
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

    public static boolean updateFood(Food newData) {
        List<Food> foods = getFoods();
        if (CollectionUtils.isEmpty(foods)) {
            return false;
        }
        for (Food food : foods) {
            if (food.getId() == newData.getId()) {
                foods.remove(food);
                foods.add(newData);
                return true;
            }
        }
        return false;
    }

    public static boolean delFood(int foodId) {
        List<Food> foods = getFoods();
        if (CollectionUtils.isEmpty(foods)) {
            return false;
        }
        for (Food food : foods) {
            if (food.getId() == foodId) {
                foods.remove(food);
                return true;
            }
        }
        return false;
    }

    public static List<FoodTemplate> getFoodTemplates() {
        return Cache.get(Constants.KEY_FOOD_TEMPLATES);
    }

    public static FoodTemplate getFoodTemplate(int foodTemplateId) {
        List<FoodTemplate> foodTemplates = getFoodTemplates();
        if (CollectionUtils.isEmpty(foodTemplates)) {
            return null;
        }
        for (FoodTemplate foodTemplate : foodTemplates) {
            if (foodTemplate.getId() == foodTemplateId) {
                return foodTemplate;
            }
        }
        return null;
    }

    public static FoodTemplate getFoodTemplateByFoodId(int foodId) {
        Food food = getFood(foodId);
        if (food == null) {
            return null;
        }
        return getFoodTemplate(food.getTemplateId());
    }
}
