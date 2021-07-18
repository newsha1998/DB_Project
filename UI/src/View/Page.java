package View;

import Logic.Portals.Portal;

import javax.swing.*;
import java.awt.*;

public abstract class Page extends JFrame {
    Portal portal;
    JComboBox comboBox;
    static int x = 400, y = 400;

    public Page(Portal portal) {
        this.portal = portal;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Label title = new Label("Choose your action!");
        Font font = new Font("serif", Font.PLAIN, 25);
        setTitle("Welcome " + portal.getName());
        title.setFont(font);
        add(title);
        title.setBounds(10, 10, 350, 75);
        comboBox = new JComboBox();
        comboBox.addItem("hello");
        comboBox.addItem("goodbye");
        add(comboBox);
        comboBox.setBounds(50, 140, 300, 50);
        JButton b = new JButton("Select");
        b.setBounds(250, 250, 100 , 50);
        add(b);
        setVisible(true);
    }
}
