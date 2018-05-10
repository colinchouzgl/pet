package actions;

import common.Constants;
import common.Response;
import dao.FoodDAO;
import dao.GlobalDAO;
import dto.FoodDto;
import entities.items.consumables.Food;
import enums.ResponseCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class PlayerAction {
    public static Response getFoods() {
        try {
            List<Food> foods = FoodDAO.getFoods();
            List<FoodDto> results = new ArrayList<>();
            foods.forEach(e -> {
                FoodDto foodDto = new FoodDto();
                foodDto.setName(FoodDAO.getFoodTemplateByFoodId(e.getId()).getName());
                foodDto.setAmount(e.getAmount());
                foodDto.setRestTimes(e.getRestTimes());
                results.add(foodDto);
            });
            Map<String, Object> data = new HashMap<>();
            data.put("foods", results);
            return Response.succeed(data);
        } catch (Exception e) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }
    }

    public static Response feedFood(int foodId) {
        Map<String, Object> data = new HashMap<>();
        if (!GlobalDAO.getFoodBowlEmpty()) {
            data.put("done", false);
            return Response.succeed(data);
        }

        Food food = FoodDAO.getFood(foodId);
        if (food == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }

        GlobalDAO.updateFoodBowlEmpty(false);
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
        data.put("done", true);
        return Response.succeed(data);
    }
}
