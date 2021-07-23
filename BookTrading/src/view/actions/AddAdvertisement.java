package view.actions;

import logic.Portal.UserPortal;
import logic.object.User;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdvertisement extends MiniPage{
    JTextField title;

    public void SetUsername(String title){
        this.title.setText(title);
        this.title.setEditable(false);
    }

    public AddAdvertisement(UserPortal portal) throws HeadlessException {
        super(portal);
        font = new Font("SansSerif", Font.PLAIN, 20);

        Label titleLabel = new Label("Title:");
        add(titleLabel);
        titleLabel.setFont(font);
        titleLabel.setBounds(20, 20, 120, 30);

        title = new JTextField();
        add(title);
        title.setFont(font);
        title.setBounds(150, 20, 150, 30);

        Label BookLabel = new Label("Book Id:");
        add(BookLabel);
        BookLabel.setFont(font);
        BookLabel.setBounds(20, 60, 120, 30);

        JTextField book = new JTextField();
        add(book);
        book.setFont(font);
        book.setBounds(150, 60, 150, 30);

        Label priceLabel = new Label("Price:");
        add(priceLabel);
        priceLabel.setFont(font);
        priceLabel.setBounds(20, 100, 100, 30);

        JTextField price = new JTextField();
        add(price);
        price.setFont(font);
        price.setBounds(150, 100, 150, 30);

        Label DescriptionLabel = new Label("Description:");
        add(DescriptionLabel);
        DescriptionLabel.setFont(font);
        DescriptionLabel.setBounds(20, 140, 130, 30);

        JTextArea description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(description);
        add(sp);
        description.setFont(font);
        sp.setBounds(20, 180, 250, 130);

        JButton add = new JButton("Add");
        add.setFont(font);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    portal.AddAdvertisement(portal.getId(), title.getText(), Integer.valueOf(book.getText()),
                            Double.valueOf(price.getText()), description.getText());
                    JOptionPane.showMessageDialog(getParent(),
                            "done successfully",
                            "",
                            JOptionPane.PLAIN_MESSAGE);
                    AddAdvertisement.this.setVisible(false);
                }
            }
        });
        add(add);
        add.setBounds(290, 220, 80, 50);
    }

}