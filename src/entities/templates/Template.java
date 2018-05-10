package entities.templates;

import entities.Entity;
import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Template extends Entity {
    private String name;
    private int price;
}
