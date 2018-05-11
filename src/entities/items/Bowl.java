package entities.items;

import common.Constants;
import enums.DirtyLevel;
import lombok.Data;

import static common.Utils.safeAdd;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Bowl extends Item {
    private int dirty;


    public Bowl() {
    }

    public Bowl(int id, int templateId) {
        super.setId(id);
        super.setTemplateId(templateId);
        this.dirty = Constants.MIN_VALUE;
    }

    public void piece() {
        dirty = safeAdd(dirty, 1);
    }

    public DirtyLevel calDirtyLevel() {
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
