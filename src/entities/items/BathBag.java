package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class BathBag extends Item {
    private int moodEffect;

    public BathBag() {
    }

    public BathBag(String name, int price, int moodEffect) {
        super.setName(name);
        super.setPrice(price);
        this.moodEffect = moodEffect;
    }
}
