package biz;

import common.Constants;
import common.Response;
import dao.GlobalDAO;
import entities.Pet;
import enums.ResponseCode;

/**
 * @author Zhou Guanliang
 * @since 2018/5/11
 */
public class PetBiz {
    public static Response startToEat() {
        Pet pet = GlobalDAO.getPet();
        if (pet == null) {
            return Response.fail(ResponseCode.DATA_EXCEPTION);
        }
        if (pet.getEatingCountDown() > 0) {
            Response.fail(ResponseCode.ALREADY_EATING);
        }
        pet.setEatingCountDown(Constants.EAT_FOOD_PERIOD);
        GlobalDAO.updatePet(pet);
        return Response.succeed();
    }
}
