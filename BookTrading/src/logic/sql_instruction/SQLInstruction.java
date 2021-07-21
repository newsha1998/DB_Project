package logic.sql_instruction;

import logic.object.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInstruction {
    Connection connection;
    Extractor extractor;

    public SQLInstruction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        extractor = new Extractor(connection);
    }

    public User extractUserProfileValues(int id) {
        return extractor.extractUserProfileValues(id);
    }
}
