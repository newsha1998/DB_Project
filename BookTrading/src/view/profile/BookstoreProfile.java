package view.profile;

import logic.Portal.Portal;
import logic.object.Bookstore;
import logic.object.User;
import view.actions.comment.CommentForBookstore;
import view.actions.comment.CommentForUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookstoreProfile extends Profile {
    TextField score;

    public BookstoreProfile(Portal portal, int id) throws HeadlessException {
        super(portal, id);

        Bookstore bookstore = portal.getBookstoreById(id);
        Label usernameLabel = new Label("Id");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 30, 130, 50);
        add(usernameLabel);

        TextField username = new TextField();
        username.setEditable(false);
        username.setBounds(150, 40, 250, 30);
        username.setText(String.valueOf(bookstore.getId()));
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 80, 130, 50);
        add(nameLabel);

        TextField name = new TextField();
        name.setEditable(false);
        name.setBounds(150, 90, 250, 30);
        name.setText(bookstore.getName());
        add(name);

        Label scoreLabel = new Label("Score");
        scoreLabel.setFont(font);
        scoreLabel.setBounds(10, 130, 130, 50);
        add(scoreLabel);

        score = new TextField();
        score.setEditable(false);
        score.setBounds(150, 140, 250, 30);
        score.setText(bookstore.getStringScore());
        add(score);
        if (bookstore.getScore() >= 7)
            score.setBackground(Color.GREEN);
        else if (bookstore.getScore() >= 4)
            score.setBackground(Color.orange);
        else if (bookstore.getScore() >= 0)
            score.setBackground(Color.RED);

        Label emailLabel = new Label("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(10, 180, 130, 50);
        add(emailLabel);

        TextField email = new TextField();
        email.setEditable(false);
        email.setBounds(150, 190, 250, 30);
        email.setText(bookstore.getEmail());
        add(email);

        Label addressLabel = new Label("Address");
        addressLabel.setFont(font);
        addressLabel.setBounds(10, 240, 130, 50);
        add(addressLabel);

        TextField address = new TextField();
        address.setEditable(false);
        address.setBounds(150, 240, 250, 30);
        address.setText(bookstore.getAdr());
        add(address);

        JButton comment = new JButton("Comment");
        comment.setFont(font);
        add(comment);
        comment.setBounds(600, 500, 200, 50);
        comment.addActionListener(new MiniActionListener2(portal, id, this));
        setVisible(true);
    }

    public void updateScore() {
        remove(score);
        Bookstore bookstore = portal.getBookstoreById(id);
        score = new TextField();
        score.setEditable(false);
        score.setBounds(150, 140, 250, 30);
        score.setText(bookstore.getStringScore());
        add(score);
        if (bookstore.getScore() >= 7)
            score.setBackground(Color.GREEN);
        else if (bookstore.getScore() >= 4)
            score.setBackground(Color.orange);
        else if (bookstore.getScore() >= 0)
            score.setBackground(Color.RED);
        setVisible(true);
        repaint();
        getParent().setVisible(true);
    }
}

class MiniActionListener2 implements ActionListener {
    BookstoreProfile profile;
    int id;
    Portal portal;
    public MiniActionListener2(Portal portal, int id, BookstoreProfile p) {
        profile = p;
        this.portal = portal;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommentForBookstore commentForUser = new CommentForBookstore(portal, id, profile);
    }
}
