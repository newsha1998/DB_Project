package logic.sql_instruction;

import logic.object.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

    public Vector<Message> GetInboxMessages(int receiverUserId) {
        Vector<Message> ret = new Vector<Message>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Message " +
                    "WHERE ReceiverUserId = ?");
            preparedStatement.setInt(1, receiverUserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message();
                message.setId(resultSet.getInt("Id"));
                message.setSenderId(resultSet.getInt("SenderUserId"));
                message.setSubject(resultSet.getString("Subject"));
                message.setText(resultSet.getString("Text"));
                message.setDate(String.valueOf(resultSet.getDate("Date")));
                message.setTime(String.valueOf(resultSet.getTime("Time")));

                preparedStatement = connection.prepareStatement("SELECT Username FROM User " +
                        "WHERE Id = ?");
                preparedStatement.setInt(1, resultSet.getInt("SenderUserId"));
                ResultSet res = preparedStatement.executeQuery();
                if(res.next())
                    message.setSenderUsername(res.getString("Username"));

                ret.add(message);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
