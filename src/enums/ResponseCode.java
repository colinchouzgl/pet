package enums;

import lombok.Getter;

/**
 * @author Zhou Guanliang
 * @since 2018/4/27
 */
public enum ResponseCode {
    ERROR(-1, "Error"),
    SUCCESS(0, "Success"),

    //1-999 System
    DATA_EXCEPTION(1, "Data exception");

    @Getter
    private final int value;
    @Getter
    private final String desc;

    ResponseCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
