package entities.items.consumables;

import entities.items.Item;
import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Consumable extends Item {
    private int amount;
    private int restTimes;
}
