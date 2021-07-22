package view.profile;

import logic.Portal.UserPortal;
import logic.object.Book;
import logic.object.User;
import logic.object.UserHasBook;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UserProfile extends Profile {
    public UserProfile(UserPortal portal, int id) throws HeadlessException {
        super(portal, id);

        User user = portal.getUserProfileValues(id);
        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 10, 130, 50);
        add(usernameLabel);

        TextField username = new TextField();
        username.setEditable(false);
        username.setBounds(150, 20, 250, 30);
        username.setText(user.getUsername());
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 60, 130, 50);
        add(nameLabel);

        TextField name = new TextField();
        name.setEditable(false);
        name.setBounds(150, 70, 250, 30);
        name.setText(user.getName());
        add(name);

        Label surnameLabel = new Label("Surname");
        surnameLabel.setFont(font);
        surnameLabel.setBounds(10, 110, 130, 50);
        add(surnameLabel);

        TextField surname = new TextField();
        surname.setEditable(false);
        surname.setBounds(150, 120, 250, 30);
        surname.setText(user.getSurname());
        add(surname);

        Label emailLabel = new Label("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(10, 160, 130, 50);
        add(emailLabel);

        TextField email = new TextField();
        email.setEditable(false);
        email.setBounds(150, 170, 250, 30);
        email.setText(user.getEmail());
        add(email);

        Label addressLabel = new Label("Address");
        addressLabel.setFont(font);
        addressLabel.setBounds(10, 210, 130, 50);
        add(addressLabel);

        TextField address = new TextField();
        address.setEditable(false);
        address.setBounds(150, 220, 250, 30);
        address.setText(user.getAddress());
        add(address);

        Label phoneLabel = new Label("Telephone");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 260, 130, 50);
        add(phoneLabel);

        TextField phone = new TextField();
        phone.setEditable(false);
        phone.setBounds(150, 270, 250, 30);
        phone.setText(user.getTelephone());
        add(phone);

        Label score_as_a_seller = new Label("Score As a Seller");
        score_as_a_seller.setFont(font);
        score_as_a_seller.setBounds(550, 10, 250, 50);
        add(score_as_a_seller);

        TextField seller = new TextField();
        seller.setEditable(false);
        seller.setBounds(800, 20, 60, 30);
        seller.setText(String.valueOf(user.getSeller()));
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
        score_as_a_purchaser.setBounds(550, 60, 250, 50);
        add(score_as_a_purchaser);

        TextField purchaser = new TextField();
        purchaser.setEditable(false);
        purchaser.setBounds(800, 70, 60, 30);
        purchaser.setText(String.valueOf(user.getPurchaser()));

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
        score_as_a_lender.setBounds(550, 110, 250, 50);
        add(score_as_a_lender);

        TextField lender = new TextField();
        lender.setEditable(false);
        lender.setBounds(800, 120, 60, 30);
        lender.setText(String.valueOf(user.getLender()));

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
        score_as_a_borrower.setBounds(550, 160, 250, 50);
        add(score_as_a_borrower);

        TextField borrower = new TextField();
        borrower.setEditable(false);
        borrower.setBounds(800, 170, 60, 30);
        borrower.setText(String.valueOf(user.getBorrower()));

        if (user.getBorrower() >= 7)
            borrower.setBackground(Color.GREEN);
        else if (user.getBorrower() >= 4)
            borrower.setBackground(Color.orange);
        else if (user.getBorrower() >= 0)
            borrower.setBackground(Color.RED);
        else
            borrower.setText("NA");
        add(borrower);

        JButton send_message_button = new JButton("Send Message");
        send_message_button.setFont(font);
        add(send_message_button);
        send_message_button.setBounds(600, 400, 200, 50);

        JButton report = new JButton("Report");
        report.setFont(font);
        add(report);
        report.setBounds(600, 480, 200, 50);

        Label booksLabel = new Label("Books");
        booksLabel.setBounds(265, 340, 60, 30);
        booksLabel.setFont(font);
        add(booksLabel);
        Vector <UserHasBook> books = portal.getUserBooks(id);
        System.out.println("Ok");
        JTable table = new JTable(UserHasBook.Convert(books), UserHasBook.getColumns());
        System.out.println("Ok");
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(100, 370, 400, 200);

        setVisible(true);
    }
}
