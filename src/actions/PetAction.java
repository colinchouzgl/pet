package actions;

import biz.PetBiz;
import common.Response;
import dao.GlobalDAO;
import entities.Pet;
import entities.templates.FoodTemplate;
import enums.PetActionState;
import enums.ResponseCode;

/**
 * @author Zhou Guanliang
 * @since 2018/5/11
 */
public class PetAction {
    public static Response eat() {
        Pet pet = GlobalDAO.getPet();
        if (pet == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }
        if (pet.getActionState() != PetActionState.NONE) {
            return Response.fail(ResponseCode.DOING_SOMETHING_ELSE);
        }
        if (GlobalDAO.getFoodBowlStock() <= 0) {
            return Response.fail(ResponseCode.NO_FOOD_IN_BOWL);
        }
        FoodTemplate foodTemplate = GlobalDAO.getFoodInBowl();
        if (foodTemplate == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }

        return PetBiz.startToEat();
    }
}
