package view.basic;

import java.awt.*;

public class ImageBox extends Canvas {
    protected String path;
    protected int a, b, c, d;

    public ImageBox(String path, int a, int b, int c, int d) {
        this.path = path;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(path);
        g.drawImage(i, a, b, c, d, this);
    }
}