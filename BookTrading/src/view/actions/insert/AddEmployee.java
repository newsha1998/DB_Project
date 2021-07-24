package view.actions.insert;

import logic.Portal.Portal;
import logic.object.Employee;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends MiniPage {
    boolean type;

    public AddEmployee(Portal portal, boolean type) throws HeadlessException {
        super(portal);
        this.type = type; //true for supporter
        Label userLabel = new Label("Username:");
        add(userLabel);
        userLabel.setFont(font);
        userLabel.setBounds(20, 20, 155,50);

        JTextField username = new JTextField();
        add(username);
        username.setFont(font);
        username.setBounds(175, 20, 200, 50);

        Label passLabel = new Label("Password:");
        add(passLabel);
        passLabel.setFont(font);
        passLabel.setBounds(20, 80, 155,50);

        JPasswordField password = new JPasswordField();
        add(password);
        password.setFont(font);
        password.setBounds(175, 80, 200, 50);

        Label nameLabel = new Label("Name:");
        add(nameLabel);
        nameLabel.setFont(font);
        nameLabel.setBounds(20, 140, 155,50);

        JTextField name = new JTextField();
        add(name);
        name.setFont(font);
        name.setBounds(175, 140, 200, 50);

        Label surnameLabel = new Label("Surname:");
        add(surnameLabel);
        surnameLabel.setFont(font);
        surnameLabel.setBounds(20, 200, 155,50);

        JTextField sur = new JTextField();
        add(sur);
        sur.setFont(font);
        sur.setBounds(175, 200, 200, 50);

        JButton register = new JButton("Register");
        register.setFont(font);
        add(register);
        register.setBounds(100, 280, 200, 50);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setFirstName(name.getText());
                employee.setUsername(username.getText());
                employee.setSurname(sur.getText());
                employee.setPassword(String.valueOf(password.getPassword()));
                if (type) {
                    portal.addSupporter(employee);
                } else {
                    portal.addAccountant(employee);
                }
                setVisible(false);
            }
        });
    }
}
