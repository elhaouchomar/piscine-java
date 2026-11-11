package geometrical_shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image implements Displayable {
    private int w, h;
    public BufferedImage image;

    public Image(int w, int h) {
        this.w = w;
        this.h = h;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    @Override
    public void display(int x, int y, Color color) {
        if (x < 0 || y < 0 || x >= w || y >= h) return;
        image.setRGB(x, y, color.getRGB());
    }

    @Override
    public void save(String filePath) {
        try {
            ImageIO.write(image, "PNG", new File(filePath));
            System.out.println("Saved image: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}
