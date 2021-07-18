package Logic;
import View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginAsAManager {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
            Instructions instructions = new Instructions(connect);
            ManagerPortal managerPortal = new ManagerPortal(instructions);
            Login login = new Login(managerPortal);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
