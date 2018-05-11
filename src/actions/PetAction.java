package actions;

import biz.GlobalBiz;
import common.Response;
import dao.GlobalDAO;
import entities.templates.FoodTemplate;
import enums.ResponseCode;

/**
 * @author Zhou Guanliang
 * @since 2018/5/11
 */
public class PetAction {
    public static Response eat() {
        if (GlobalDAO.getFoodBowlStock() <= 0) {
            return Response.fail(ResponseCode.NO_FOOD_IN_BOWL);
        }
        FoodTemplate foodTemplate = GlobalDAO.getFoodInBowl();
        if (foodTemplate == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }

        return GlobalBiz.startToEat();
    }
}
