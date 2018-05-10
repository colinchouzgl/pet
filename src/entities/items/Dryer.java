package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Dryer extends Item {
    private int wetnessEffect;
    private int moodEffect;

    Dryer() {
    }

    Dryer(String name, int price, int wetnessEffect, int moodEffect) {
        super.setName(name);
        super.setPrice(price);
        this.wetnessEffect = wetnessEffect;
        this.moodEffect = moodEffect;
    }
}
