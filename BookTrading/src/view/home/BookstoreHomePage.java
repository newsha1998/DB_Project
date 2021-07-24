package view.home;

import logic.Manager;
import logic.Portal.BookstorePortal;
import logic.Portal.Portal;
import logic.object.Bookstore;

import javax.swing.*;
import java.awt.*;

public class BookstoreHomePage extends HomePage {
    public BookstoreHomePage(BookstorePortal portal) throws HeadlessException {
        super(portal);
        Bookstore bookstore = portal.getBookstoreById(portal.getId());

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 10, 130, 50);
        add(usernameLabel);

        JTextField username = new JTextField();
        username.setEditable(false);
        username.setBounds(150, 20, 250, 30);
        username.setText(bookstore.getUsername());
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 60, 130, 50);
        add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(150, 70, 250, 30);
        name.setText(bookstore.getName());
        add(name);

        Label scoreLabel = new Label("Score");
        scoreLabel.setFont(font);
        scoreLabel.setBounds(10, 110, 130, 50);
        add(scoreLabel);

        JTextField score = new JTextField();
        score.setBounds(150, 120, 250, 30);
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
        emailLabel.setBounds(10, 160, 130, 50);
        add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(150, 170, 250, 30);
        email.setText(bookstore.getEmail());
        add(email);

        Label cityLabel = new Label("City");
        cityLabel.setFont(font);
        cityLabel.setBounds(10, 210, 130, 50);
        add(cityLabel);

        JTextField city = new JTextField();
        city.setBounds(150, 220, 250, 30);
        city.setText(bookstore.getCity());
        add(city);

        Label regionLabel = new Label("Region");
        regionLabel.setFont(font);
        regionLabel.setBounds(10, 260, 130, 50);
        add(regionLabel);

        JTextField region = new JTextField();
        region.setBounds(150, 270, 250, 30);
        region.setText(bookstore.getRegion());
        add(region);

        Label streetLabel = new Label("Street");
        streetLabel.setFont(font);
        streetLabel.setBounds(10, 310, 130, 50);
        add(streetLabel);

        JTextField street = new JTextField();
        street.setBounds(150, 320, 250, 30);
        street.setText(bookstore.getStreet());
        add(street);

        Label alleyLabel = new Label("Alley");
        alleyLabel.setFont(font);
        alleyLabel.setBounds(10, 360, 130, 50);
        add(alleyLabel);

        JTextField alley = new JTextField();
        alley.setBounds(150, 370, 250, 30);
        alley.setText(bookstore.getAlley());
        add(alley);

        Label hnLabel = new Label("No.");
        hnLabel.setFont(font);
        hnLabel.setBounds(10, 410, 130, 50);
        add(hnLabel);

        JTextField hn = new JTextField();
        hn.setBounds(150, 420, 250, 30);
        hn.setText(bookstore.getBuilding());
        add(hn);

        Label phoneLabel = new Label("Telephone");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 460, 130, 50);
        add(phoneLabel);

        JTextField phone = new JTextField();
        phone.setBounds(150, 470, 250, 30);
        phone.setText(bookstore.getPhone());
        add(phone);


    }
}
