package view.actions.update;

import logic.Portal.Portal;
import view.basic.MiniPage;
import view.home.BookstoreHomePage;
import view.list.MiniBookList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpdateBookstoreBookShelf extends MiniPage {
    BookstoreHomePage homePage;
    public UpdateBookstoreBookShelf(Portal portal, BookstoreHomePage homePage) throws HeadlessException {
        super(portal);
        this.homePage = homePage;
        Label actionTypeLabel = new Label("Action Type:");
        add(actionTypeLabel);
        actionTypeLabel.setFont(font);
        actionTypeLabel.setBounds(20, 0, 150, 50);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Change Book Number");
        comboBox.addItem("Change Book Price");
        comboBox.addItem("Add Book");
        comboBox.addItem("Remove Book");
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

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getSelectedItem().equals("Change Book Price")) {
                    numberLabel.setText("Price:");
                    number.setVisible(true);
                }
                if (comboBox.getSelectedItem().equals("Change Book Number")) {
                    numberLabel.setText("Number");
                    number.setVisible(true);
                }
                if (comboBox.getSelectedItem().equals("Add Book")) {
                    numberLabel.setText("");
                    number.setVisible(false);
                }
                if (comboBox.getSelectedItem().equals("Remove Book")) {
                    numberLabel.setText("");
                    number.setVisible(false);
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
                if (comboBox.getSelectedItem().equals("Change Book Price")) {
                    portal.updateBookstoreBookPrice(Integer.parseInt(bookId.getText()), Double.parseDouble(number.getText()));
                }
                if (comboBox.getSelectedItem().equals("Change Book Number")) {
                    portal.updateBookstoreBookNumber(Integer.parseInt(bookId.getText()), Integer.parseInt(number.getText()));
                }
                if (comboBox.getSelectedItem().equals("Add Book")) {
                    portal.addBookstoreBook(Integer.parseInt(bookId.getText()));
                }
                if (comboBox.getSelectedItem().equals("Remove Book")) {
                    portal.removeBookstoreBook(Integer.parseInt(bookId.getText()));
                }
                bookId.setText("");
                number.setText("");
                homePage.bookUpdateSignal();
            }
        });
    }
}
