package view.basic;

import logic.Portal.Portal;

import javax.swing.*;
import java.awt.*;

public abstract class MiniPage extends JFrame {
    protected static int x = 400, y = 400;
    protected Portal portal;
    protected Font font = new Font("SansSerif", Font.PLAIN, 20);

    public MiniPage(Portal portal) throws HeadlessException {
        this.portal = portal;
        setSize(x, y);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}
