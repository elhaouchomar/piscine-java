package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    int x, y;
    Color color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = getColor();
    }

    public static Point random(int maxX, int maxY) {
        Random rand = new Random();
        return new Point(rand.nextInt(maxX), rand.nextInt(maxY));
    }

    @Override
    public void draw(Displayable d) {
        d.display(x, y, color);
    }
}
