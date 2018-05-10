package entities.templates;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class HouseTemplate extends Template {
    private int energyEffect;
    private int sickChance;
    private int sickEffect;
}
