package Logic.StartingPage;
import Logic.Instructions;
import Logic.Portals.MemberPortal;
import View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginAsAMember {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
            Instructions instructions = new Instructions(connect);
            MemberPortal memberPortal = new MemberPortal(instructions);
            Login login = new Login(memberPortal);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
