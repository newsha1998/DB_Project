package View.Actions;

import Logic.Portals.ManagerPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeReg extends JFrame {
    private static final int x = 400, y = 270;
    ManagerPortal portal;

    public EmployeeReg(ManagerPortal portal) {
        this.portal = portal;

        setSize(x, y);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);

        Label firstName = new Label("FirstName");
        firstName.setBounds(10, 20, 100, 20);
        add(firstName);
        TextField first = new TextField();
        first.setBounds(150, 20, 150, 20);
        add(first);

        Label surname = new Label("Surname");
        surname.setBounds(10, 50, 100, 20);
        add(surname);
        TextField sur = new TextField();
        sur.setBounds(150, 50, 150, 20);
        add(sur);

        Label password = new Label("Password");
        password.setBounds(10, 80, 100, 20);
        add(password);
        TextField pass = new TextField();
        pass.setBounds(150, 80, 150, 20);
        add(pass);

        JButton sub = new JButton("Register");
        add(sub);
        sub.setBounds(150, 140, 100, 30);
        setVisible(true);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = portal.registerEmployee(first.getText(), sur.getText(), pass.getText());
                JOptionPane.showMessageDialog(getParent(),
                        "The Employee is " + id,
                        "Register Complete",
                        JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
            }
        });
    }
}
