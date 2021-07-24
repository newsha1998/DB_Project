package view.actions.buy;

import logic.Portal.Portal;
import logic.object.Buy;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyFromUser extends MiniPage {

    JButton buy;
    JTextArea description, DeliveryAddress;
    JTextField price;
    int sellerId, buyerId, BookId;
    String address;
    JTextField username;
    JTextField book;
    Buy b;

    public BuyFromUser(Portal portal) {
        super(portal);
        b = new Buy();
        b.setBuyerId(portal.getId());

        font = new Font("SansSerif", Font.PLAIN, 20);

        Label usernameLabel = new Label("Seller:");
        add(usernameLabel);
        usernameLabel.setFont(font);
        usernameLabel.setBounds(20, 20, 120, 30);

        username = new JTextField();
        add(username);
        username.setFont(font);
        username.setBounds(170, 20, 150, 30);


        Label BookLabel = new Label("Book Id:");
        add(BookLabel);
        BookLabel.setFont(font);
        BookLabel.setBounds(20, 60, 120, 30);

        book = new JTextField();
        add(book);
        book.setFont(font);
        book.setBounds(170, 60, 150, 30);


        Label priceLabel = new Label("Price:");
        add(priceLabel);
        priceLabel.setFont(font);
        priceLabel.setBounds(20, 100, 100, 30);

        price = new JTextField();
        add(price);
        price.setFont(font);
        price.setBounds(170, 100, 150, 30);


        Label DescriptionLabel = new Label("Description:");
        add(DescriptionLabel);
        DescriptionLabel.setFont(font);
        DescriptionLabel.setBounds(20, 140, 130, 30);

        description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(description);
        add(sp);
        description.setFont(font);
        sp.setBounds(20, 170, 150, 100);


        Label addressLabel = new Label("Address:");
        add(addressLabel);
        addressLabel.setFont(font);
        addressLabel.setBounds(230, 140, 130, 30);

        DeliveryAddress = new JTextArea();
        DeliveryAddress.setLineWrap(true);
        DeliveryAddress.setWrapStyleWord(true);
        JScrollPane sp2 = new JScrollPane(DeliveryAddress);
        add(sp2);
        DeliveryAddress.setFont(font);
        sp2.setBounds(230, 170, 150, 100);


        buy = new JButton("Buy");
        buy.setFont(font);
        add(buy);
        buy.setBounds(160, 300, 80, 50);

    }

    public JButton getBuy() {
        return buy;
    }

    public JTextArea getDescription() {
        return description;
    }

    public void setDescription(JTextArea description) {
        this.description = description;
    }

    public JTextField getPrice() {
        return price;
    }

    public void setPrice(JTextField price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JTextField getBook() {
        return book;
    }

    public void setBook(JTextField book) {
        this.book = book;
    }

    public JTextArea getDeliveryAddress() {
        return DeliveryAddress;
    }

    public Buy getB() {
        return b;
    }

    public void setBuyParametrs() {
        b.setSellerUserName(username.getText());
        b.setBookId(Integer.parseInt(book.getText()));
        b.setPrice(Double.parseDouble(price.getText()));
        b.setDescription(description.getText());
        b.setDeliveryAddress(DeliveryAddress.getText());
    }
}

