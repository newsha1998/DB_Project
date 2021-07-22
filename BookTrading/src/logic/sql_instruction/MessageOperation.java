package logic.sql_instruction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageOperation extends Instruction {
    public MessageOperation(Connection connection) {
        super(connection);
    }

    public void SendMessage(int senderId, String receiverUsername, String subject, String text){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM User " +
                    "WHERE Username = ?;");
            preparedStatement.setString(1, receiverUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rid = resultSet.getInt("Id");
                PreparedStatement pr = connection.prepareStatement("INSERT INTO Message " +
                        "(SenderUserId, ReceiverUserId, Subject, Text) " +
                        "VALUES (?, ?, ?, ?);");
                pr.setInt(1, senderId);
                pr.setInt(2, rid);
                pr.setString(3, subject);
                pr.setString(4, text);
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
