package actions;

import common.Constants;
import common.Response;
import dao.FoodDAO;
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
                foodDto.setRestRatio(100 * e.getRest() / Constants.FOOD_BAG_CAPACITY);
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
        return Response.succeed();
    }
}
