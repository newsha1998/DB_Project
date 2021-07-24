package view.actions.wallet;

import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends MiniPage {
    int Id;
    String type, Date, Time, CreditCardNumber, Description;
    double amount;
    boolean status;
    public Transaction(Portal portal) {
        super(portal);

        font = new Font("SansSerif", Font.PLAIN, 20);

        Label IdLabel = new Label("Transaction Id:");
        add(IdLabel);
        IdLabel.setFont(font);
        IdLabel.setBounds(20, 20, 180, 30);

        JTextField Id = new JTextField();
        add(Id);
        Id.setFont(font);
        Id.setBounds(200, 20, 150, 30);

        Label amountLabel = new Label("Amount:");
        add(amountLabel);
        amountLabel.setFont(font);
        amountLabel.setBounds(20, 60, 180, 30);

        JTextField amount = new JTextField();
        add(amount);
        amount.setFont(font);
        amount.setBounds(200, 60, 150, 30);


        Label DescriptionLabel = new Label("Description:");
        add(DescriptionLabel);
        DescriptionLabel.setFont(font);
        DescriptionLabel.setBounds(20, 100, 130, 30);

        JTextArea description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(description);
        add(sp);
        description.setFont(font);
        sp.setBounds(20, 140, 250, 130);

        JButton done = new JButton("Done");
        done.setFont(font);

        add(done);
        done.setBounds(290, 220, 80, 50);
    }
}

