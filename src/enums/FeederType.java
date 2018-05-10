package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public enum FeederType {
    FOOD(0, "food"),
    WATER(1, "water"),

    ERROR(-1, "ERROR");

    @Getter
    private final int value;
    @Getter
    private final String desc;

    FeederType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static FeederType fromValue(Integer value) {
        for (FeederType e : FeederType.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return ERROR;
    }
}
