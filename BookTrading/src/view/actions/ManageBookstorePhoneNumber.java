package view.actions;

import logic.Portal.BookstorePortal;
import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageBookstorePhoneNumber extends MiniPage {
    public ManageBookstorePhoneNumber(BookstorePortal portal) throws HeadlessException {
        super(portal);
        Label actionTypeLabel = new Label("Action Type:");
        add(actionTypeLabel);
        actionTypeLabel.setFont(font);
        actionTypeLabel.setBounds(20, 0, 150, 50);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Add Telephone");
        comboBox.addItem("Remove Telephone");
        add(comboBox);
        comboBox.setFont(font);
        comboBox.setBounds(50, 50, 300, 50);

        Label bookIdLabel = new Label("Telephone:");
        add(bookIdLabel);
        bookIdLabel.setFont(font);
        bookIdLabel.setBounds(20, 130, 150, 50);

        JTextField bookId = new JTextField();
        add(bookId);
        bookId.setFont(font);
        bookId.setBounds(170, 130, 200, 50);

        JButton submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.setBounds(200, 270, 150, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Add Telephone")) {
                    portal.addPhone(bookId.getText());
                } else {
                    portal.removePhone(bookId.getText());
                }
                bookId.setText("");
            }
        });
    }
}
