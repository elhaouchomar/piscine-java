package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    Point center;
    int radius;
    Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = getColor();
    }

    public static Circle random(int maxX, int maxY) {
        Random rand = new Random();
        Point center = new Point(rand.nextInt(maxX), rand.nextInt(maxY));
        int radius = rand.nextInt(Math.min(maxX, maxY) / 2 + 1);
        return new Circle(center, radius);
    }

    @Override
    public void draw(Displayable d) {
        int cx = this.center.x;
        int cy = this.center.y;
        int r = this.radius;

        if (r <= 0)
            return;

        double circumference = 2.0 * Math.PI * r;
        double inc = 360.0 / circumference;
        double i = 0.0;

        while (i <= 360.0) {
            double theta = Math.toRadians(i);
            int x = (int) Math.round(cx + r * Math.cos(theta));
            int y = (int) Math.round(cy + r * Math.sin(theta));
            d.display(x, y, this.color);

            i += inc;
        }
    }
}