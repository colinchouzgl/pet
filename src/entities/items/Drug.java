package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Drug extends Item {
    private int healthEffect;
    private int moodEffect;

    public Drug() {
    }

    public Drug(String name, int price, int healthEffect, int moodEffect) {
        super.setName(name);
        super.setPrice(price);
        this.healthEffect = healthEffect;
        this.moodEffect = moodEffect;
    }
}
