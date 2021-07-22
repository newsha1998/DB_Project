package view.basic;

import logic.Portal.Portal;

import javax.swing.*;
import java.awt.*;

public abstract class Panel extends JPanel {
    protected Portal portal;
    protected Font font = new Font("SansSerif", Font.PLAIN, 20);
    static int x = 900, y = 700;

    public Panel(Portal portal) {
        this.portal = portal;
        setSize(x, y);
        setLayout(null);
        setVisible(true);
    }
}
