package Logic.StartingPage;
import Logic.Portals.EmployeePortal;
import Logic.Instructions;
import View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginAsAnEmployee {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
            Instructions instructions = new Instructions(connect);
            EmployeePortal employeePortal = new EmployeePortal(instructions);
            Login login = new Login(employeePortal);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
