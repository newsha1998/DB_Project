package View;

import Logic.Portals.MemberPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accept extends JFrame {
    MemberPortal portal;
    static int x = 370, y = 170;

    public Accept(MemberPortal portal) throws HeadlessException {
        this.portal = portal;
        this.portal = portal;
        this.portal = portal;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);

        Label len = new Label("Enter Borrow ID");
        len.setBounds(10, 20, 100, 20);
        add(len);
        TextField lender = new TextField();
        lender.setBounds(150, 20, 150, 20);
        add(lender);

        JButton sub = new JButton("Submit");
        add(sub);
        sub.setBounds(150, 75, 100, 30);
        setVisible(true);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                portal.acceptBorrow(Integer.parseInt(lender.getText()));
                setVisible(false);
            }
        });
    }
}
