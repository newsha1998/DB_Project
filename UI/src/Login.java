import javax.swing.*;
import java.awt.*;
import java.awt.*;
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
    private static final int x = 400, y = 300;
    public Login() {
        setSize(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JButton b=new JButton("Sign In");
        b.setBounds(100,200,95,30);
        add(b);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TextField textField = new TextField ();
        Label id = new Label("ID");
        id.setBounds(50, 45, 40, 40);
        add(id);
        textField.setBounds(50, 50, 150, 30);
        add(textField);
        setVisible(true);
    }
}
