package view.profile;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import logic.object.User;
import logic.object.UserHasBook;
import view.actions.message.SendMessage;
import view.actions.comment.CommentForUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserProfile extends Profile {
    JButton send_message_button;

    TextField seller, lender, purchaser, borrower;

    public UserProfile(Portal portal, int id) throws HeadlessException {
        super(portal, id);

        User user = portal.getUserProfileValues(id);
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 30, 130, 50);
        add(usernameLabel);

        TextField username = new TextField();
        username.setEditable(false);
        username.setBounds(150, 40, 250, 30);
        username.setText(user.getUsername());
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 80, 130, 50);
        add(nameLabel);

        TextField name = new TextField();
        name.setEditable(false);
        name.setBounds(150, 90, 250, 30);
        name.setText(user.getName());
        add(name);

        Label surnameLabel = new Label("Surname");
        surnameLabel.setFont(font);
        surnameLabel.setBounds(10, 130, 130, 50);
        add(surnameLabel);

        TextField surname = new TextField();
        surname.setEditable(false);
        surname.setBounds(150, 140, 250, 30);
        surname.setText(user.getSurname());
        add(surname);

        Label emailLabel = new Label("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(10, 180, 130, 50);
        add(emailLabel);

        TextField email = new TextField();
        email.setEditable(false);
        email.setBounds(150, 190, 250, 30);
        email.setText(user.getEmail());
        add(email);

        Label addressLabel = new Label("Address");
        addressLabel.setFont(font);
        addressLabel.setBounds(10, 230, 130, 50);
        add(addressLabel);

        TextField address = new TextField();
        address.setEditable(false);
        address.setBounds(150, 240, 250, 30);
        address.setText(user.getAddress());
        add(address);

        Label phoneLabel = new Label("Telephone");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 280, 130, 50);
        add(phoneLabel);

        TextField phone = new TextField();
        phone.setEditable(false);
        phone.setBounds(150, 290, 250, 30);
        phone.setText(user.getTelephone());
        add(phone);

        Label score_as_a_seller = new Label("Score As a Seller");
        score_as_a_seller.setFont(font);
        score_as_a_seller.setBounds(550, 30, 250, 50);
        add(score_as_a_seller);

        seller = new TextField();
        seller.setEditable(false);
        seller.setBounds(800, 40, 60, 30);
        seller.setText(String.format("%.2f",user.getSeller()));
        if (user.getSeller() >= 7)
            seller.setBackground(Color.GREEN);
        else if (user.getSeller() >= 4)
            seller.setBackground(Color.orange);
        else if (user.getSeller() >= 0)
            seller.setBackground(Color.RED);
        else
            seller.setText("NA");
        add(seller);

        Label score_as_a_purchaser = new Label("Score As a Purchaser");
        score_as_a_purchaser.setFont(font);
        score_as_a_purchaser.setBounds(550, 80, 250, 50);
        add(score_as_a_purchaser);

        purchaser = new TextField();
        purchaser.setEditable(false);
        purchaser.setBounds(800, 90, 60, 30);
        purchaser.setText(String.format("%.2f", user.getPurchaser()));

        if (user.getPurchaser() >= 7)
            purchaser.setBackground(Color.GREEN);
        else if (user.getPurchaser() >= 4)
            purchaser.setBackground(Color.orange);
        else if (user.getPurchaser() >= 0)
            purchaser.setBackground(Color.RED);
        else
            purchaser.setText("NA");
        add(purchaser);

        Label score_as_a_lender = new Label("Score As a Lender");
        score_as_a_lender.setFont(font);
        score_as_a_lender.setBounds(550, 130, 250, 50);
        add(score_as_a_lender);

        lender = new TextField();
        lender.setEditable(false);
        lender.setBounds(800, 140, 60, 30);
        lender.setText(String.format("%.2f", user.getLender()));

        if (user.getLender() >= 7)
            lender.setBackground(Color.GREEN);
        else if (user.getLender() >= 4)
            lender.setBackground(Color.orange);
        else if (user.getLender() >= 0)
            lender.setBackground(Color.RED);
        else
            lender.setText("NA");
        add(lender);

        Label score_as_a_borrower = new Label("Score As a Borrower");
        score_as_a_borrower.setFont(font);
        score_as_a_borrower.setBounds(550, 180, 250, 50);
        add(score_as_a_borrower);

        borrower = new TextField();
        borrower.setEditable(false);
        borrower.setBounds(800, 190, 60, 30);
        borrower.setText(String.format("%.2f", user.getBorrower()));

        if (user.getBorrower() >= 7)
            borrower.setBackground(Color.GREEN);
        else if (user.getBorrower() >= 4)
            borrower.setBackground(Color.orange);
        else if (user.getBorrower() >= 0)
            borrower.setBackground(Color.RED);
        else
            borrower.setText("NA");
        add(borrower);

        send_message_button = new JButton("Send Message");
        send_message_button.setFont(font);
        add(send_message_button);
        send_message_button.setBounds(600, 420, 200, 50);

        JButton comment = new JButton("Comment");
        comment.setFont(font);
        add(comment);
        comment.setBounds(600, 500, 200, 50);
        comment.addActionListener(new MiniActionListener(portal, id, this));

        Label booksLabel = new Label("Books");
        booksLabel.setBounds(265, 360, 60, 30);
        booksLabel.setFont(font);
        add(booksLabel);
        Vector <UserHasBook> books = portal.getUserBooks(id);
        JTable table = new JTable(UserHasBook.getRows(books), UserHasBook.getColumns());
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(100, 390, 400, 200);

        send_message_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage send = new SendMessage((UserPortal)portal);
                send.SetUsername(portal.getUserProfileValues(id).getUsername());
            }
        });

        setVisible(true);
    }

    public JButton getSend_message_button() {
        return send_message_button;
    }

    public void updateScore() {
        User user = portal.getUserProfileValues(id);
        remove(seller);
        seller = new TextField();
        seller.setEditable(false);
        seller.setBounds(800, 40, 60, 30);
        seller.setText(String.format("%.2f", user.getSeller()));
        if (user.getSeller() >= 7)
            seller.setBackground(Color.GREEN);
        else if (user.getSeller() >= 4)
            seller.setBackground(Color.orange);
        else if (user.getSeller() >= 0)
            seller.setBackground(Color.RED);
        else
            seller.setText("NA");
        add(seller);
        remove(purchaser);
        purchaser = new TextField();
        purchaser.setEditable(false);
        purchaser.setBounds(800, 90, 60, 30);
        purchaser.setText(String.format("%.2f", user.getPurchaser()));

        if (user.getPurchaser() >= 7)
            purchaser.setBackground(Color.GREEN);
        else if (user.getPurchaser() >= 4)
            purchaser.setBackground(Color.orange);
        else if (user.getPurchaser() >= 0)
            purchaser.setBackground(Color.RED);
        else
            purchaser.setText("NA");
        add(purchaser);
        remove(lender);
        lender = new TextField();
        lender.setEditable(false);
        lender.setBounds(800, 140, 60, 30);
        lender.setText(String.format("%.2f", user.getLender()));

        if (user.getLender() >= 7)
            lender.setBackground(Color.GREEN);
        else if (user.getLender() >= 4)
            lender.setBackground(Color.orange);
        else if (user.getLender() >= 0)
            lender.setBackground(Color.RED);
        else
            lender.setText("NA");
        add(lender);
        remove(borrower);
        borrower = new TextField();
        borrower.setEditable(false);
        borrower.setBounds(800, 190, 60, 30);
        borrower.setText(String.format("%.2f", user.getBorrower()));

        if (user.getBorrower() >= 7)
            borrower.setBackground(Color.GREEN);
        else if (user.getBorrower() >= 4)
            borrower.setBackground(Color.orange);
        else if (user.getBorrower() >= 0)
            borrower.setBackground(Color.RED);
        else
            borrower.setText("NA");
        add(borrower);

        setVisible(true);
    }
}

class MiniActionListener implements ActionListener {
    UserProfile profile;
    int id;
    Portal portal;
    public MiniActionListener(Portal portal, int id, UserProfile p) {
        profile = p;
        this.portal = portal;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommentForUser commentForUser = new CommentForUser(portal, id, profile);
    }
}
