package view.actions.comment;

import logic.Portal.Portal;
import logic.object.Comment;
import view.profile.Profile;
import view.profile.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForUser extends CommentPage {
    UserProfile profile;
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
                Comment comment = new Comment();
                comment.setSenderId(portal.getId());
                comment.setrId(portal.getUsetIdByUsername(username.getText()));
                comment.setSub(subject.getText());
                comment.setText(text.getText());
                comment.setScore(Double.parseDouble(String.valueOf(score.getValue())));
                if (comboBox.getSelectedItem().equals("As a Seller")) {
                    comment.setrType("Seller");
                }
                if (comboBox.getSelectedItem().equals("As a Lender")) {
                    comment.setrType("Lender");
                }
                if (comboBox.getSelectedItem().equals("As a Borrower")) {
                    comment.setrType("Borrower");
                }
                if (comboBox.getSelectedItem().equals("As a Purchaser")) {
                    comment.setrType("Purchaser");
                }
                portal.insertCommentForUser(comment);
                if (profile != null) {
                    profile.updateScore();
                }
                setVisible(false);
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

    public CommentForUser(Portal portal, int id, UserProfile profile) throws HeadlessException {
        super(portal);
        this.profile = profile;
        String u = portal.getUserProfileValues(id).getUsername();
        username.setText(u);
        username.setEditable(false);
        makeChanges();
    }
}
