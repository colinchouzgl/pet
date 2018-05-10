package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Food extends Item {
    private int hungerEffect;
    private int sickChance;
    private int sickEffect;

    Food() {
    }

    Food(String name, int price, int hungerEffect, int sickChance, int sickEffect) {
        super.setName(name);
        super.setPrice(price);
        this.hungerEffect = hungerEffect;
        this.sickChance = sickChance;
        this.sickEffect = sickEffect;
    }
}
