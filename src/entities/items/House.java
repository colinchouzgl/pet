package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class House extends Item {
    private int energyEffect;
    private int sickChance;
    private int sickEffect;

    public House() {
    }

    public House(String name, int price, int energyEffect, int sickChance, int sickEffect) {
        super.setName(name);
        super.setPrice(price);
        this.energyEffect = energyEffect;
        this.sickChance = sickChance;
        this.sickEffect = sickEffect;
    }
}
