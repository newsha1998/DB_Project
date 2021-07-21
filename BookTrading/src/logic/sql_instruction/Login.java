package logic.sql_instruction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Instruction {
    public Login(Connection connection) {
        super(connection);
    }

    public int loginAsUser (String username, String pass) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT Id FROM User " +
                    "WHERE Username = ? AND Password = ?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
