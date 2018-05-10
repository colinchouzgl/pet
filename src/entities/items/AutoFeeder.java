package entities.items;

import common.Constants;
import enums.FeederType;
import lombok.Data;

import static common.Utils.safeSub;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class AutoFeeder extends Item {
    private int durability;
    private FeederType type;

    AutoFeeder() {
    }

    AutoFeeder(String name, int price, FeederType type) {
        super.setName(name);
        super.setPrice(price);
        this.durability = Constants.MAX_VALUE;
        this.type = type;
    }

    public void piece() {
        durability = safeSub(durability, 1);
    }
}
