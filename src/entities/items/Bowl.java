package entities.items;

import common.Constants;
import enums.DirtyLevel;
import enums.FeederType;
import lombok.Data;

import static common.Utils.safeAdd;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Bowl extends Item {
    private int dirty;
    private FeederType type;

    Bowl() {
    }

    Bowl(String name, int price, FeederType type) {
        super.setName(name);
        super.setPrice(price);
        this.dirty = Constants.MIN_VALUE;
        this.type = type;
    }

    public void piece() {
        dirty = safeAdd(dirty, 1);
    }

    public DirtyLevel getDirtyLevel() {
        if (dirty < DirtyLevel.BIT_DIRTY.getFigure()) {
            return DirtyLevel.CLEAN;
        }
        if (dirty >= DirtyLevel.BIT_DIRTY.getFigure() && dirty < DirtyLevel.DIRTY.getFigure()) {
            return DirtyLevel.BIT_DIRTY;
        }
        if (dirty >= DirtyLevel.DIRTY.getFigure() && dirty < DirtyLevel.VERY_DIRTY.getFigure()) {
            return DirtyLevel.DIRTY;
        }
        if (dirty >= DirtyLevel.VERY_DIRTY.getFigure()) {
            return DirtyLevel.VERY_DIRTY;
        }
        return DirtyLevel.ERROR;
    }
}
