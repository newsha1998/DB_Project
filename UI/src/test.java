import Logic.Instructions;
import Logic.Portals.MemberPortal;
import View.MemberPage;
import View.MessageBox;
import View.ReadMessages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager
                .getConnection("jdbc:mysql://localhost/BookTrading?"
                        + "user=root&password=");
        Instructions instructions = new Instructions(connect);
        System.out.println(instructions.getMessagesId(1).size());

    }
}
