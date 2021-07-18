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


public class Start {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
            Instructions instructions = new Instructions(connect);
            instructions.addUserAccount("fa", "gh", "mypassword");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
