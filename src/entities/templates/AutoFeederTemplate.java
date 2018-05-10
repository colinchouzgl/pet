package entities.templates;

import enums.FeederType;
import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class AutoFeederTemplate extends Template {
    private FeederType type;
}
