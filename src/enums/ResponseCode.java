package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/4/27
 */
public enum ResponseCode {
    ERROR(-1, "Error"),
    SUCCESS(0, "Success"),

    //1-9999 System
    DATA_EXCEPTION(1, "Data exception"),

    /**
     * 1001-5000 Player Action
     */
    //1001-1100 Feed Food
    FOOD_NOT_ENOUGH(1001, "Food not enough"),

    //1101-1200 Feed Water
    //...
    /**
     * 5001-9999 Pet Action
     */
    //5001-5100 Eat Food
    NO_FOOD_IN_BOWL(5001, "No food in the bowl"),
    ALREADY_EATING(5002, "Is already eating");


    @Getter
    private final int value;
    @Getter
    private final String desc;

    ResponseCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
