package view.actions.wallet;
import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends MiniPage {
    int id;
    String type, Date, Time, CreditCardNumber, Description;
    double amount, available;
    boolean status;
    JButton done;
    JTextArea description;
    JTextField Amount, Id;
    public Transaction(Portal portal) {
        super(portal);
        this.available = available;
        this.type = type;


        font = new Font("SansSerif", Font.PLAIN, 20);

        Label amountLabel = new Label("Amount:");
        add(amountLabel);
        amountLabel.setFont(font);
        amountLabel.setBounds(20, 60, 130, 30);

        Amount = new JTextField();
        add(Amount);
        Amount.setFont(font);
        Amount.setBounds(150, 60, 150, 30);


        Label DescriptionLabel = new Label("Description:");
        add(DescriptionLabel);
        DescriptionLabel.setFont(font);
        DescriptionLabel.setBounds(20, 100, 130, 30);

        description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(description);
        add(sp);
        description.setFont(font);
        sp.setBounds(20, 140, 320, 130);

        done = new JButton("Done");
        done.setFont(font);
        add(done);
        done.setBounds(150, 280, 100, 50);
    }

    public void setAvailable(Double a) {
        available =a;
    }

    public JButton getDone() {
        return done;
    }

    public void setDone(JButton done) {
        this.done = done;
    }

    public JTextArea getDescription() {
        return description;
    }

    public void setDescription(JTextArea description) {
        this.description = description;
    }

    public JTextField getAmount() {
        return Amount;
    }

    public void setAmount(JTextField amount) {
        Amount = amount;
    }

    public JTextField getId() {
        return Id;
    }

    public void setId(JTextField id) {
        Id = id;
    }
}
