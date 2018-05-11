package biz;

import common.Constants;
import common.Response;
import dao.FoodDAO;
import dao.GlobalDAO;
import dto.FoodDto;
import entities.items.consumables.Food;
import enums.ResponseCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhou Guanliang
 * @since 2018/5/11
 */
public class FoodBiz {
    public static List<FoodDto> getFoods() {
        List<Food> foods = FoodDAO.getFoods();
        List<FoodDto> results = new ArrayList<>();
        foods.forEach(e -> {
            FoodDto foodDto = new FoodDto();
            foodDto.setName(FoodDAO.getFoodTemplateByFoodId(e.getId()).getName());
            foodDto.setAmount(e.getAmount());
            foodDto.setRestTimes(e.getRestTimes());
            results.add(foodDto);
        });
        return results;
    }

    public static Response feedFood(int foodId) {
        Food food = FoodDAO.getFood(foodId);
        if (food == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }

        GlobalDAO.updateFoodBowlStock(Constants.FOOD_BOWL_MAX_STOCK);
        if (food.getRestTimes() > 1) {
            food.setRestTimes(food.getRestTimes() - 1);
        } else if (food.getRestTimes() == 1) {
            if (food.getAmount() > 1) {
                food.setRestTimes(Constants.FOOD_FEED_TIMES_PER_BAG);
            } else {
                food.setRestTimes(0);
            }
            food.setAmount(food.getAmount() - 1);
        } else {
            return Response.fail(ResponseCode.FOOD_NOT_ENOUGH);
        }
        FoodDAO.updateFood(food);
        return Response.succeed();
    }
}
