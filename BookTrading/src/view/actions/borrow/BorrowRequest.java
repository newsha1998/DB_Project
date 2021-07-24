package view.actions.borrow;

import logic.Portal.Portal;
import logic.object.Borrow;
import view.basic.Panel;

import javax.swing.*;
import java.awt.*;

public class BorrowRequest extends Panel {
    JTextArea address, description;
    JButton addReq;
    JTextField username, bookId, StartDate, DeadlineDate, Price, Guarantee, delay;

    public BorrowRequest(Portal portal) {
        super(portal);


        Label nameLabel = new Label("Lender Username:");
        nameLabel.setFont(font);
        add(nameLabel);
        nameLabel.setBounds(20, 80, 260, 50);

        username = new JTextField();
        username.setFont(font);
        add(username);
        username.setBounds(280, 80, 150, 50);

        Label bookIdLabel = new Label("Book Id:");
        bookIdLabel.setFont(font);
        add(bookIdLabel);
        bookIdLabel.setBounds(20, 150, 260, 50);

        bookId = new JTextField();
        bookId.setFont(font);
        add(bookId);
        bookId.setBounds(280, 150, 150, 50);

        Label StartDateLabel = new Label("Start Date:");
        StartDateLabel.setFont(font);
        add(StartDateLabel);
        StartDateLabel.setBounds(20, 220, 260, 50);

        StartDate = new JTextField();
        StartDate.setFont(font);
        add(StartDate);
        StartDate.setBounds(280, 220, 150, 50);

        Label DeadlineDateLabel = new Label("Deadline Date:");
        DeadlineDateLabel.setFont(font);
        add(DeadlineDateLabel);
        DeadlineDateLabel.setBounds(20, 290, 260, 50);

        DeadlineDate = new JTextField();
        DeadlineDate.setFont(font);
        add(DeadlineDate);
        DeadlineDate.setBounds(280, 290, 150, 50);


        Label PriceLabel = new Label("Borrow Price:");
        PriceLabel.setFont(font);
        add(PriceLabel);
        PriceLabel.setBounds(20, 360, 260, 50);

        Price = new JTextField();
        Price.setFont(font);
        add(Price);
        Price.setBounds(280, 360, 150, 50);

        Label GuaranteePriceLabel = new Label("Guarantee Price:");
        GuaranteePriceLabel.setFont(font);
        add(GuaranteePriceLabel);
        GuaranteePriceLabel.setBounds(20, 430, 260, 50);

        Guarantee = new JTextField();
        Guarantee.setFont(font);
        add(Guarantee);
        Guarantee.setBounds(280, 430, 150, 50);

        Label delayLabel = new Label("Daily Delay Penalty:");
        delayLabel.setFont(font);
        add(delayLabel);
        delayLabel.setBounds(20, 500, 260, 50);

        delay = new JTextField();
        delay.setFont(font);
        add(delay);
        delay.setBounds(280, 500, 150, 50);

        Label DeliveryAddressLabel = new Label("Delivery Address:");
        DeliveryAddressLabel.setFont(font);
        add(DeliveryAddressLabel);
        DeliveryAddressLabel.setBounds(500, 80, 180, 50);

        address = new JTextArea();
        address.setFont(font);
        address.setLineWrap(true);
        address.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(address);
        add(sp);
        sp.setBounds(500, 140, 330, 150);

        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setFont(font);
        add(descriptionLabel);
        descriptionLabel.setBounds(500, 350, 150, 50);

        description = new JTextArea();
        description.setFont(font);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        JScrollPane sp2 = new JScrollPane(description);
        add(sp2);
        sp2.setBounds(500, 400, 330, 150);

        addReq = new JButton("Add Request");
        add(addReq);
        addReq.setFont(font);
        addReq.setBounds(350, 580, 200, 50);

    }

    public JButton getAddReq() {
        return addReq;
    }

    public JTextArea getAddress() {
        return address;
    }

    public JTextArea getDescription() {
        return description;
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getBookId() {
        return bookId;
    }

    public JTextField getStartDate() {
        return StartDate;
    }

    public JTextField getDeadlineDate() {
        return DeadlineDate;
    }

    public JTextField getPrice() {
        return Price;
    }

    public JTextField getGuarantee() {
        return Guarantee;
    }

    public JTextField getDelay() {
        return delay;
    }
}
