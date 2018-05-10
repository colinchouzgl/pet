import entities.Pet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhou Guanliang
 * @since 2017/8/9
 */
public class Game {
    public static Pet pet;
    private static int money;
    private static Set<Supply> allSupplies = new HashSet<>();

//    static {
//        money = 100;
//        allSupplies.add(new Supply(SupplyType.food, "平价猫粮", 1, 10, 2));
//        allSupplies.add(new Supply(SupplyType.food, "优质猫粮", 2, 10, 2));
//    }

    public static void start() {
        pet = new Pet("Java");
        Test.start();
    }

    public static void main(String[] args){
        start();
    }
}
