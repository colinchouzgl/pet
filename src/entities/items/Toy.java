package entities.items;

import lombok.Data;

/**
 * @author Zhou Guanliang
 * @since 2018/5/10
 */
@Data
public class Toy extends Item {
    private int moodEffect;
    private

    Toy() {
    }

    Toy(String name, int price, int moodEffect) {
        super.setName(name);
        super.setPrice(price);
        this.moodEffect = moodEffect;
    }
}
