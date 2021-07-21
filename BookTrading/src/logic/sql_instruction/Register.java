package logic.sql_instruction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register extends Instruction {

    public Register(Connection connection) {
        super(connection);
    }

    public int registerUser(String username, String password, String name, String surname) {
        //Return 1 if everything is ok
        //Return 0 if we have the same username
        //Return -1 if the password is not enough strong
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM User " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return 0;
            if (password.length() < 8)
                return -1;
            preparedStatement = connection.prepareStatement("INSERT INTO User (Username, FirstName, Surname, Password) " +
                    "VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -2;
    }
}
