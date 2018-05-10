package entities.templates;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class DryerTemplate extends Template {
    private int wetnessEffect;
    private int moodEffect;
}
