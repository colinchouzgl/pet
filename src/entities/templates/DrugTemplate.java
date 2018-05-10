package entities.templates;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class DrugTemplate extends Template {
    private int healthEffect;
    private int moodEffect;
}
