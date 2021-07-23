package view.actions;

import logic.Portal.UserPortal;
import view.basic.MiniPage;
import view.basic.Page;
import view.home.UserHomePage;
import view.list.MiniBookList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpdateBookPanel extends MiniPage {
    UserHomePage homePage;
    public UpdateBookPanel(UserPortal portal, UserHomePage homePage) throws HeadlessException {
        super(portal);
        this.homePage = homePage;
        Label actionTypeLabel = new Label("Action Type:");
        add(actionTypeLabel);
        actionTypeLabel.setFont(font);
        actionTypeLabel.setBounds(20, 0, 150, 50);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Add Book");
        comboBox.addItem("Remove Book");
        comboBox.addItem("Change Status");
        add(comboBox);
        comboBox.setFont(font);
        comboBox.setBounds(50, 50, 300, 50);

        Label bookIdLabel = new Label("Book ID:");
        add(bookIdLabel);
        bookIdLabel.setFont(font);
        bookIdLabel.setBounds(20, 130, 100, 50);

        JTextField bookId = new JTextField();
        add(bookId);
        bookId.setFont(font);
        bookId.setBounds(120, 130, 100, 50);

        JButton choose = new JButton("Choose");
        choose.setFont(font);
        add(choose);
        choose.setBounds(230, 130, 150, 50);
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MiniBookList miniBookList = new MiniBookList(portal);
                miniBookList.getAdd().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookId.setText(String.valueOf(miniBookList.getSelected()));
                    }
                });
            }
        });
        Label numberLabel = new Label("Number:");
        add(numberLabel);
        numberLabel.setFont(font);
        numberLabel.setBounds(20, 190, 100, 50);

        JTextField number = new JTextField();
        add(number);
        number.setFont(font);
        number.setBounds(120, 190, 100, 50);

        Label statusLabel = new Label("Status:");
        add(statusLabel);
        statusLabel.setFont(font);
        statusLabel.setBounds(20, 190, 100, 50);
        statusLabel.setVisible(false);

        JTextField status = new JTextField();
        add(status);
        status.setFont(font);
        status.setBounds(120, 190, 100, 50);
        status.setVisible(false);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getSelectedItem().equals("Change Status")) {
                    status.setVisible(true);
                    statusLabel.setVisible(true);
                    numberLabel.setVisible(false);
                    number.setVisible(false);
                } else {
                    status.setVisible(false);
                    statusLabel.setVisible(false);
                    numberLabel.setVisible(true);
                    number.setVisible(true);
                }
            }
        });

        JButton submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.setBounds(200, 270, 150, 50);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Add Book")) {
                    portal.addBook(Integer.parseInt(bookId.getText()), Integer.parseInt(number.getText()));
                } else if  (comboBox.getSelectedItem().equals("Remove Book")) {
                    portal.romoveBook(Integer.parseInt(bookId.getText()), Integer.parseInt(number.getText()));
                } else {
                    portal.changeBookStatus(Integer.parseInt(bookId.getText()), status.getText());
                }
                bookId.setText("");
                status.setText("");
                number.setText("");
                homePage.bookUpdateSignal();
            }
        });
    }
}
