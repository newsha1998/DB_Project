package Logic.StartingPage;
import Logic.Portals.BookstorePortal;
import Logic.Instructions;
import View.Actions.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginAsABookstore {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
            Instructions instructions = new Instructions(connect);
            BookstorePortal bookstorePortal = new BookstorePortal(instructions);
            Login login = new Login(bookstorePortal);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
