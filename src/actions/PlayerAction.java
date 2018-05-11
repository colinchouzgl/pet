package actions;

import biz.FoodBiz;
import common.Response;
import dao.GlobalDAO;
import enums.ResponseCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class PlayerAction {
    public static Response getFoods() {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("foods", FoodBiz.getFoods());
            return Response.succeed(data);
        } catch (Exception e) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }
    }

    public static Response feedFood(int foodId) {
        Map<String, Object> data = new HashMap<>();
        if (GlobalDAO.getFoodBowlStock() <= 0) {
            data.put("hasRest", true);
            return Response.succeed(data);
        }
        Response response = FoodBiz.feedFood(foodId);
        if (response.isSuccess()) {
            data.put("hasRest", false);
            response.setData(data);
        }
        return response;
    }
}
