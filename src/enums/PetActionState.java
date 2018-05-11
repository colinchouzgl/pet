package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
public enum PetActionState {
    NONE(0, "none"),
    EATING(1, "eating"),
    DRINKING(2, "drinking"),
    EATING_SNACK(3, "eating snack"),
    BATHING(4, "bathing"),
    DRYING(5, "drying"),
    SLEEPING(6, "sleeping"),
    ENTERTAINING(7, "entertaining"),
    COMMUNICATING(8, "communicating"),
    PLAYING(9, "playing"),
    CURING(10, "curing"),
    IN_HOSPITAL(11, "in hospital"),

    ERROR(-1, "ERROR");

    @Getter
    private final int value;
    @Getter
    private final String desc;

    PetActionState(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static PetActionState fromValue(Integer value) {
        for (PetActionState e : PetActionState.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return ERROR;
    }
}
