package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public enum ToyType {
    SELF(0, 1, "self-entertain toy"),
    INTERACT(1, 2, "interact-play toy"),

    ERROR(-1, -1, "ERROR");

    @Getter
    private final int value;
    @Getter
    private final int energyEffect;
    @Getter
    private final String desc;

    ToyType(int value, int energyEffect, String desc) {
        this.value = value;
        this.energyEffect = energyEffect;
        this.desc = desc;
    }

    public static ToyType fromValue(Integer value) {
        for (ToyType e : ToyType.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return ERROR;
    }
}
