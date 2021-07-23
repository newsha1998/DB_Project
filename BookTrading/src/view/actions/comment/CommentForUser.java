package view.actions.comment;

import logic.Portal.Portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForUser extends CommentPage {
    public CommentForUser(Portal portal) throws HeadlessException {
        super(portal);

        makeChanges();
    }

    private void makeChanges() {
        usernameLabel.setText("Username:");
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("As a Seller");
        comboBox.addItem("As a Lender");
        comboBox.addItem("As a Borrower");
        comboBox.addItem("As a Purchaser");
        comboBox.setFont(font);
        add(comboBox);
        comboBox.setBounds(20, 300, 180, 50);
        setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public CommentForUser(Portal portal, int id) throws HeadlessException {
        super(portal);

        String u = portal.getUserProfileValues(id).getUsername();
        username.setText(u);
        username.setEditable(false);
        makeChanges();
    }
}
