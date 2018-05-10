package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public enum DirtyLevel {
    CLEAN(0, 0, "clean"),
    BIT_DIRTY(1, 25, "bit dirty"),
    DIRTY(2, 50, "dirty"),
    VERY_DIRTY(3, 75, "very dirty"),

    ERROR(-1, -1, "ERROR");

    @Getter
    private final int value;
    @Getter
    private final int figure;
    @Getter
    private final String desc;

    DirtyLevel(int value, int figure, String desc) {
        this.value = value;
        this.figure = figure;
        this.desc = desc;
    }

    public static DirtyLevel fromValue(Integer value) {
        for (DirtyLevel e : DirtyLevel.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return ERROR;
    }
}
