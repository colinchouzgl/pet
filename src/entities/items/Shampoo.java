package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Shampoo extends Item {
    private int cleanlinessEffect;

    public Shampoo() {
    }

    public Shampoo(String name, int price, int cleanlinessEffect) {
        super.setName(name);
        super.setPrice(price);
        this.cleanlinessEffect = cleanlinessEffect;
    }
}
