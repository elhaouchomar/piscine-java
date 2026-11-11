package geometrical_shapes;

import java.awt.Color;

public class Rectangle implements Drawable {
    Point tl, br;
    Color color;

    public Rectangle(Point tl, Point br) {
        this.tl = tl;
        this.br = br;
        this.color = getColor();
    }

    @Override
    public void draw(Displayable d) {
        Point tr = new Point(br.x, tl.y);
        Point bl = new Point(tl.x, br.y);

        new Line(tl, tr, color).draw(d);
        new Line(tl, bl, color).draw(d);
        new Line(tr, br, color).draw(d);
        new Line(bl, br, color).draw(d);
    }
}
