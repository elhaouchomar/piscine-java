package geometrical_shapes;

import java.awt.Color;

public class Triangle implements Drawable {
    Point p1, p2, p3;
    Color color;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = getColor();
    }

    @Override
    public void draw(Displayable d) {
        new Line(p1, p2, color).draw(d);
        new Line(p2, p3, color).draw(d);
        new Line(p3, p1, color).draw(d);
    }
}
