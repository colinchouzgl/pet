package entities.templates;

import enums.FeederType;
import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class BowlTemplate extends Template {
    private FeederType type;
}
