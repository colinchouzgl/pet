package entities.items;

import common.Constants;
import lombok.Data;

import static common.Utils.safeSub;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class WaterCleaner extends Item {
    private int durability;

    WaterCleaner() {
    }

    WaterCleaner(String name, int price) {
        super.setName(name);
        super.setPrice(price);
        this.durability = Constants.MAX_VALUE;
    }

    public void piece() {
        durability = safeSub(durability, 1);
    }
}
