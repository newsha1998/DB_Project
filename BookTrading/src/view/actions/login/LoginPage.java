package view.actions.login;

import logic.Portal.*;
import logic.object.Bookstore;
import logic.object.Employee;
import view.basic.ImageBox;
import view.basic.Page;
import view.home.BookstoreHomePage;
import view.home.EmployeeHomePage;
import view.home.ManagerHomePage;
import view.home.UserHomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginPage extends Page {

    public LoginPage(Portal portal) throws HeadlessException {
        super(portal);
        menuBar.setVisible(false);
        getContentPane().setBackground(Color.white);
        Label usernameLabel = new Label("Username:");
        getContentPane().add(usernameLabel);
        usernameLabel.setFont(font);
        usernameLabel.setBounds(550, 150, 110, 50);

        TextField user = new TextField();
        getContentPane().add(user);
        user.setBounds(700, 150, 150, 50);
        user.setFont(font);

        Label passwordLabel = new Label("Password:");
        getContentPane().add(passwordLabel);
        passwordLabel.setFont(font);
        passwordLabel.setBounds(550, 250, 110, 50);

        JPasswordField pass = new JPasswordField();
        getContentPane().add(pass);
        pass.setBounds(700, 250, 150, 50);
        pass.setFont(font);

        JButton signin = new JButton("Sign In");
        signin.setFont(font);
        add(signin);
        signin.setBounds(600, 450, 200, 50);

        int a = 0, b = 0, c = 500, d = 700;
        ImageBox background = new ImageBox("resource/login.png", a, b, c, d);
        getContentPane().add(background);
        background.setBounds(a, b, c, d);
        repaint();
        setVisible(true);

        if (portal instanceof UserPortal) {
            JButton signup = new JButton("Sign Up");
            signup.setFont(font);
            getContentPane().add(signup);
            signup.setBounds(600, 550, 200, 50);
            signup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    usernameLabel.setVisible(false);
                    user.setVisible(false);
                    pass.setVisible(false);
                    passwordLabel.setVisible(false);
                    signin.setVisible(false);

                    Label ul = new Label("Username: ");
                    getContentPane().add(ul);
                    ul.setFont(font);
                    ul.setBounds(550, 70, 110, 50);
                    TextField u = new TextField();
                    getContentPane().add(u);
                    u.setFont(font);
                    u.setBounds(700, 70, 150, 50);
                    u.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (((UserPortal) portal).existUser(u.getText())) {
                                u.setBackground(Color.red);
                            } else {
                                u.setBackground(Color.white);
                            }
                        }
                    });


                    Label pl = new Label("Password: ");
                    getContentPane().add(pl);
                    pl.setFont(font);
                    pl.setBounds(550, 140, 110, 50);
                    JPasswordField p1 = new JPasswordField();
                    getContentPane().add(p1);
                    p1.setFont(font);
                    p1.setBounds(700, 140, 150, 50);
                    p1.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (p1.getPassword().length < 8) {
                                p1.setBackground(Color.red);
                            } else {
                                p1.setBackground(Color.white);
                            }
                        }
                    });


                    Label pl2 = new Label("Repeat Pass: ");
                    getContentPane().add(pl2);
                    pl2.setFont(font);
                    pl2.setBounds(550, 210, 140, 50);
                    JPasswordField p2 = new JPasswordField();
                    getContentPane().add(p2);
                    p2.setFont(font);
                    p2.setBounds(700, 210, 150, 50);
                    p2.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (!(String.valueOf(p1.getPassword()).equals(String.valueOf(p2.getPassword())))) {
                                p2.setBackground(Color.red);
                            } else {
                                p2.setBackground(Color.white);
                            }
                        }
                    });

                    Label nl = new Label("FirstName: ");
                    getContentPane().add(nl);
                    nl.setFont(font);
                    nl.setBounds(550, 280, 140, 50);
                    TextField nn = new TextField();
                    getContentPane().add(nn);
                    nn.setFont(font);
                    nn.setBounds(700, 280, 150, 50);

                    Label sl = new Label("Surname: ");
                    getContentPane().add(sl);
                    sl.setFont(font);
                    sl.setBounds(550, 350, 140, 50);
                    TextField sur = new TextField();
                    getContentPane().add(sur);
                    sur.setFont(font);
                    sur.setBounds(700, 350, 150, 50);

                    signup.setVisible(false);
                    JButton register = new JButton("Register");
                    getContentPane().add(register);
                    register.setBounds(600, 550, 200, 50);
                    register.setFont(font);

                    register.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (String.valueOf(p1.getPassword()).equals(String.valueOf(p2.getPassword()))) {
                                int ret = ((UserPortal) portal).registerUser(u.getText(), String.valueOf(p1.getPassword()), nn.getText(), sur.getText());
                                if (ret == 1) {
                                    JOptionPane.showMessageDialog(getParent(),
                                            "You've registered successfully.",
                                            "Successful Register",
                                            JOptionPane.PLAIN_MESSAGE);
                                    u.setVisible(false);
                                    ul.setVisible(false);
                                    p1.setVisible(false);
                                    p2.setVisible(false);
                                    pl.setVisible(false);
                                    pl2.setVisible(false);
                                    sl.setVisible(false);
                                    nl.setVisible(false);
                                    nn.setVisible(false);
                                    sur.setVisible(false);
                                    register.setVisible(false);
                                    signin.setVisible(true);
                                    signup.setVisible(true);
                                    usernameLabel.setVisible(true);
                                    user.setVisible(true);
                                    pass.setVisible(true);
                                    passwordLabel.setVisible(true);
                                } else if (ret == 0) {
                                    JOptionPane.showMessageDialog(getParent(),
                                            "Try another username!",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(getParent(),
                                            "Short length password!",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(getParent(),
                                        "Passwords are not match.",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                }
            });
        }
        repaint();

        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ret = portal.login(user.getText(), String.valueOf(pass.getPassword()));
                if (ret) {
                    JOptionPane.showMessageDialog(getParent(),
                            "You are Login.",
                            "Welcome",
                            JOptionPane.PLAIN_MESSAGE);
                    setVisible(false);
                    if (portal instanceof UserPortal) {
                        setContentPane(new UserHomePage((UserPortal) portal));
                        setVisible(true);
                        menuBar.setVisible(true);
                    }
                    if (portal instanceof ManagerPortal) {
                        setContentPane(new ManagerHomePage((ManagerPortal) portal));
                        setVisible(true);
                        menuBar.setVisible(true);
                    }
                    if (portal instanceof BookstorePortal) {
                        setContentPane(new BookstoreHomePage((BookstorePortal) portal));
                        setVisible(true);
                        menuBar.setVisible(true);
                    }
                    if (portal instanceof EmployeePortal) {
                        setContentPane(new EmployeeHomePage((EmployeePortal) portal));
                        setVisible(true);
                        menuBar.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(getParent(),
                            "Wrong ID or Password.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    user.setText("");
                    pass.setText("");
                }
            }
        });

    }
}
