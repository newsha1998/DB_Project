package view.actions.comment;

import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;

public class CommentForUser extends Comment {
    public CommentForUser(Portal portal) throws HeadlessException {
        super(portal);

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
    }
}
