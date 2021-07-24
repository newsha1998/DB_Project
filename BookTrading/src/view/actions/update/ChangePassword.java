package view.actions.update;

import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends MiniPage {

    public ChangePassword(Portal portal) throws HeadlessException {
        super(portal);

        Label oldLabel = new Label("Old Password:");
        add(oldLabel);
        oldLabel.setFont(font);
        oldLabel.setBounds(20, 20, 155,50);

        JPasswordField old = new JPasswordField();
        add(old);
        old.setFont(font);
        old.setBounds(175, 20, 200, 50);

        Label newLabel = new Label("New Password:");
        add(newLabel);
        newLabel.setFont(font);
        newLabel.setBounds(20, 80, 155, 50);

        JPasswordField new1 = new JPasswordField();
        add(new1);
        new1.setFont(font);
        new1.setBounds(175, 80, 200, 50);

        Label newLabel2 = new Label("Repeat:");
        add(newLabel2);
        newLabel2.setFont(font);
        newLabel2.setBounds(20, 140, 155, 50);

        JPasswordField new2 = new JPasswordField();
        add(new2);
        new2.setFont(font);
        new2.setBounds(175, 140, 200, 50);

        JButton submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.setBounds(100, 250, 200, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (String.valueOf(new1.getPassword()).equals(String.valueOf(new2.getPassword()))) {
                    if (String.valueOf(new1.getPassword()).length() < 8) {
                        JOptionPane.showMessageDialog(getParent(),
                                "Short Length Password!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        if(portal.changePassword(String.valueOf(old.getPassword()), String.valueOf(new1.getPassword()))) {
                            JOptionPane.showMessageDialog(getParent(),
                                    "Done successfully.",
                                    "Successful Register",
                                    JOptionPane.PLAIN_MESSAGE);
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(getParent(),
                                    "Wrong Password!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(getParent(),
                            "Passwords are not match!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                old.setText("");
                new1.setText("");
                new2.setText("");
            }
        });
    }
}
