package view.home;

import logic.object.Manager;
import logic.Portal.ManagerPortal;
import view.actions.update.ChangePassword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomePage extends HomePage {
    public ManagerHomePage(ManagerPortal portal) throws HeadlessException {
        super(portal);

        Manager manager = portal.getManager();

        Label usernameLabel = new Label("Username");
        usernameLabel.setFont(font);
        usernameLabel.setBounds(10, 10, 130, 50);
        add(usernameLabel);

        JTextField username = new JTextField();
        username.setEditable(false);
        username.setBounds(150, 20, 250, 30);
        username.setText(manager.getUsername());
        add(username);

        Label nameLabel = new Label("Name");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 60, 130, 50);
        add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(150, 70, 250, 30);
        name.setText(manager.getFirstname());
        add(name);

        Label surnameLabel = new Label("Surname");
        surnameLabel.setFont(font);
        surnameLabel.setBounds(10, 110, 130, 50);
        add(surnameLabel);

        JTextField surname = new JTextField();
        surname.setBounds(150, 120, 250, 30);
        surname.setText(manager.getSurname());
        add(surname);

        Label emailLabel = new Label("Email");
        emailLabel.setFont(font);
        emailLabel.setBounds(10, 160, 130, 50);
        add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(150, 170, 250, 30);
        email.setText(manager.getEmail());
        add(email);

        Label cityLabel = new Label("City");
        cityLabel.setFont(font);
        cityLabel.setBounds(10, 210, 130, 50);
        add(cityLabel);

        JTextField city = new JTextField();
        city.setBounds(150, 220, 250, 30);
        city.setText(manager.getCity());
        add(city);

        Label regionLabel = new Label("Region");
        regionLabel.setFont(font);
        regionLabel.setBounds(10, 260, 130, 50);
        add(regionLabel);

        JTextField region = new JTextField();
        region.setBounds(150, 270, 250, 30);
        region.setText(manager.getRegion());
        add(region);

        Label streetLabel = new Label("Street");
        streetLabel.setFont(font);
        streetLabel.setBounds(10, 310, 130, 50);
        add(streetLabel);

        JTextField street = new JTextField();
        street.setBounds(150, 320, 250, 30);
        street.setText(manager.getStreet());
        add(street);

        Label alleyLabel = new Label("Alley");
        alleyLabel.setFont(font);
        alleyLabel.setBounds(10, 360, 130, 50);
        add(alleyLabel);

        JTextField alley = new JTextField();
        alley.setBounds(150, 370, 250, 30);
        alley.setText(manager.getAlley());
        add(alley);

        Label hnLabel = new Label("No.");
        hnLabel.setFont(font);
        hnLabel.setBounds(10, 410, 130, 50);
        add(hnLabel);

        JTextField hn = new JTextField();
        hn.setBounds(150, 420, 250, 30);
        hn.setText(manager.getHousenumber());
        add(hn);

        Label phoneLabel = new Label("Telephone");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 460, 130, 50);
        add(phoneLabel);

        JTextField phone = new JTextField();
        phone.setBounds(150, 470, 250, 30);
        phone.setText(manager.getTelephone());
        add(phone);

        Label nationLabel = new Label("National ID");
        nationLabel.setFont(font);
        nationLabel.setBounds(450, 10, 130, 50);
        add(nationLabel);

        JTextField national = new JTextField();
        national.setBounds(580, 20, 250, 30);
        national.setText(manager.getNationalId());
        add(national);

        JButton update = new JButton("Update Profile");
        update.setFont(font);
        add(update);
        update.setBounds(525, 400, 250, 50);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    Manager m = new Manager();
                    m.setId(manager.getId());
                    m.setNationalId(national.getText());
                    m.setFirstname(name.getText());
                    m.setSurname(surname.getText());
                    m.setEmail(email.getText());
                    m.setCity(city.getText());
                    m.setRegion(region.getText());
                    m.setStreet(street.getText());
                    m.setAlley(alley.getText());
                    m.setHousenumber(hn.getText());
                    m.setTelephone(phone.getText());
                    portal.updateManager(m);
                }
            }
        });

        JButton changePass = new JButton("Change Password");
        changePass.setFont(font);
        add(changePass);
        changePass.setBounds(525, 480, 250, 50);
        changePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword changePassword = new ChangePassword(portal);
            }
        });
        setVisible(true);
    }
}
