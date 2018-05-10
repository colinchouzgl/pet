package entities.templates;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class WaterCleanerTemplate extends Template {
    private int sickChance;
    private int sickEffect;
}
