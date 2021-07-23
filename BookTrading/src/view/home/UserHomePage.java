package view.home;

import logic.Portal.UserPortal;
import logic.object.User;
import logic.object.UserHasBook;
import view.actions.UpdateBookPanel;
import view.basic.ModifyedActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

public class UserHomePage extends HomePage {
    JScrollPane scrollPane;
    JTable table;

    public UserHomePage(UserPortal portal) throws HeadlessException {
        super(portal);
        User user = portal.getUserProfileValues(portal.getId());

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 10, 130, 50);
        add(usernameLabel);

        JTextField username = new JTextField();
        username.setEditable(false);
        username.setBounds(150, 20, 250, 30);
        username.setText(user.getUsername());
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 60, 130, 50);
        add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(150, 70, 250, 30);
        name.setText(user.getName());
        add(name);

        Label surnameLabel = new Label("Surname");
        surnameLabel.setFont(font);
        surnameLabel.setBounds(10, 110, 130, 50);
        add(surnameLabel);

        JTextField surname = new JTextField();
        surname.setBounds(150, 120, 250, 30);
        surname.setText(user.getSurname());
        add(surname);

        Label emailLabel = new Label("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(10, 160, 130, 50);
        add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(150, 170, 250, 30);
        email.setText(user.getEmail());
        add(email);

        Label addressLabel = new Label("Address");
        addressLabel.setFont(font);
        addressLabel.setBounds(10, 210, 130, 50);
        add(addressLabel);

        FocusListener fk = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        };

        JTextField city = new JTextField("City");
        city.addFocusListener(fk);
        city.setBounds(150, 220, 50, 30);
        if (user.getCity()!=null) {
            city.setText(user.getCity());
            city.removeFocusListener(fk);
        }
        add(city);

        JTextField region = new JTextField("Region");
        region.addFocusListener(fk);
        region.setBounds(200, 220, 50, 30);
        if (user.getRegion() != null) {
            region.setText(user.getRegion());
            region.removeFocusListener(fk);
        }
        add(region);

        JTextField street = new JTextField("Street");
        street.addFocusListener(fk);
        street.setBounds(250, 220, 50, 30);
        if (user.getStreet()!=null) {
            street.setText(user.getStreet());
            street.removeFocusListener(fk);
        }
        add(street);

        JTextField alley = new JTextField("Alley");
        alley.addFocusListener(fk);
        alley.setBounds(300, 220, 50, 30);
        if (user.getAlley()!=null)
            alley.setText(user.getAlley());
        add(alley);

        JTextField no = new JTextField("No.");
        no.addFocusListener(fk);
        no.setBounds(350, 220, 50, 30);
        if (user.getHouseNumber()!=null) {
            no.setText(user.getHouseNumber());
            no.removeFocusListener(fk);
        }
        add(no);

        Label phoneLabel = new Label("Telephone");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 260, 130, 50);
        add(phoneLabel);

        JTextField phone = new JTextField();
        phone.setBounds(150, 270, 250, 30);
        phone.setText(user.getTelephone());
        add(phone);

        Label score_as_a_seller = new Label("Score As a Seller");
        score_as_a_seller.setFont(font);
        score_as_a_seller.setBounds(550, 10, 250, 50);
        add(score_as_a_seller);

        JTextField seller = new JTextField();
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

        JTextField purchaser = new JTextField();
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

        JTextField lender = new JTextField();
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

        JTextField borrower = new JTextField();
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

        JButton update = new JButton("Update Profile");
        update.setFont(font);
        add(update);
        update.setBounds(600, 400, 200, 50);

        JButton edit_book_list = new JButton("Edit Book List");
        edit_book_list.setFont(font);
        add(edit_book_list);
        edit_book_list.setBounds(600, 480, 200, 50);

        Label booksLabel = new Label("Books");
        booksLabel.setBounds(265, 340, 60, 30);
        booksLabel.setFont(font);
        add(booksLabel);
        Vector<UserHasBook> books = portal.getUserBooks(portal.getId());
        table = new JTable(UserHasBook.getRows(books), UserHasBook.getColumns());
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(100, 370, 400, 200);

        setVisible(true);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    if (!city.getText().equals("") && !city.getText().equals("City")) {
                        ((UserPortal)portal).UpdateUser("city", username.getText(), city.getText());
                        user.setCity(city.getText());
                    }

                    if (!region.getText().equals("") && !region.getText().equals("Region")) {
                        ((UserPortal)portal).UpdateUser("region", username.getText(), region.getText());
                        user.setRegion(region.getText());
                    }

                    if (!street.getText().equals("") && !street.getText().equals("Street")) {
                        ((UserPortal)portal).UpdateUser("street", username.getText(), street.getText());
                        user.setStreet(street.getText());
                    }

                    if (!alley.getText().equals("") && !alley.getText().equals("Alley")) {
                        ((UserPortal)portal).UpdateUser("alley", username.getText(), alley.getText());
                        user.setAlley(alley.getText());
                    }

                    if (!no.getText().equals("") && !no.getText().equals("No.")) {
                        ((UserPortal)portal).UpdateUser("HouseNo", username.getText(), no.getText());
                        user.setHouseNumber(no.getText());
                    }

                    if (!phone.getText().equals("")) {
                        ((UserPortal)portal).UpdateUser("phone", username.getText(), phone.getText());
                        user.setTelephone(phone.getText());
                    }

                    if (!name.getText().equals("")) {
                        ((UserPortal)portal).UpdateUser("name", username.getText(), name.getText());
                        user.setName(name.getText());
                    }

                    if (!surname.getText().equals("")) {
                        ((UserPortal)portal).UpdateUser("surname", username.getText(), surname.getText());
                        user.setSurname(surname.getText());
                    }

                    if (!email.getText().equals("")) {
                        ((UserPortal)portal).UpdateUser("email", username.getText(), email.getText());
                        user.setEmail(email.getText());
                    }

                    JOptionPane.showMessageDialog(getParent(),
                            "Updated successfully.",
                            "",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        edit_book_list.addActionListener(new ModifyedActionListener(this) {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBookPanel updateBookPanel = new UpdateBookPanel(portal, homePage);
            }
        });
    }

    public void bookUpdateSignal() {
        UserPortal port = (UserPortal) portal;
        Vector<UserHasBook> books = port.getUserBooks(port.getId());
        table = new JTable(UserHasBook.getRows(books), UserHasBook.getColumns());
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(100, 370, 400, 200);
        setVisible(true);
    }
}
