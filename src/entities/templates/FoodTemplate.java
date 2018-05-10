package entities.templates;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class FoodTemplate extends Template {
    private int hungerEffect;
    private int sickChance;
    private int sickEffect;
}
