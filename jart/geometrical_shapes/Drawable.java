package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public interface Drawable {
    void draw(Displayable displayable);

    default Color getColor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b, 255);
    }
}
