package actions;

import common.Response;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class PlayerAction {
    public static Response getOwnedFoods(){
        return Response.succeed();
    }

    public static Response feedFood(int foodId) {
        return Response.succeed();
    }
}
