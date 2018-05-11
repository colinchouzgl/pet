package common;

import dao.GlobalDAO;
import entities.Pet;
import entities.templates.FoodTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public class Scheduler {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void run() {
        pool.submit(() -> {
            while (true) {
                Pet pet = GlobalDAO.getPet();
                if (pet == null || pet.checkIsDead()) {
                    return;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                pet.globalPiece();

                if (pet.getEatingCountDown() > 0) {
                    FoodTemplate foodTemplate = GlobalDAO.getFoodInBowl();
                    if (foodTemplate != null) {
                        pet.eatPiece(foodTemplate.getHungerEffect(), foodTemplate.getSickChance(), foodTemplate.getSickEffect());
                    }
                    pet.setEatingCountDown(pet.getEatingSnackCountDown() - 1);
                    GlobalDAO.updatePet(pet);
                }
            }
        });
    }
}
