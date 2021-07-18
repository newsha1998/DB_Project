package View;

import Logic.MemberPortal;
import Logic.Portal;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import javax.swing.*;

public class Login extends JFrame{
    private static final int x = 400, y = 270;
    Portal portal;

    public Login(Portal port) {
        portal = port;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JButton b=new JButton("Sign In");
        b.setBounds(150,170,95,30);
        add(b);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("serif", Font.PLAIN, 30);
        TextField id = new TextField ();
        Label id_lable = new Label("ID");
        id_lable.setFont(font);
        id_lable.setBounds(50, 45, 40, 40);
        add(id_lable);
        id.setBounds(220, 50, 150, 30);
        add(id);

        TextField pass = new TextField ();
        Label pass_lable = new Label("Password");
        pass_lable.setFont(font);
        pass_lable.setBounds(50, 90, 150, 40);
        add(pass_lable);
        pass.setBounds(220, 95, 150, 30);
        add(pass);
        setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean ret = port.login(Integer.parseInt(id.getText()), pass.getText());
                    if (ret) {
                        JOptionPane.showMessageDialog(getParent(),
                                "You are Login.",
                                "Welcome",
                                JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(getParent(),
                                "Wrong ID or Password.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    pass.setText("");
                    id.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
