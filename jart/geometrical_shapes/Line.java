package geometrical_shapes;

import java.awt.Color;

public class Line implements Drawable {
    private Point start, end;
    Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = getColor();
    }

    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public static Line random(int maxX, int maxY) {
        return new Line(Point.random(maxX, maxY), Point.random(maxX, maxY));
    }

    @Override
    public void draw(Displayable d) {
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        if (steps == 0) {
            d.display(start.x, start.y, color);
            return;
        }
        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;
        float x = start.x;
        float y = start.y;
        for (int i = 0; i <= steps; i++) {
            d.display(Math.round(x), Math.round(y), color);
            x += xInc;
            y += yInc;
        }
    }
}
