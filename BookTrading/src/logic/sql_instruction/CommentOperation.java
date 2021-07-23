package logic.sql_instruction;

import logic.object.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentOperation extends Instruction {
    public CommentOperation(Connection connection) {
        super(connection);
    }

    public Comment getCommentById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Comment Where Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(id);
                comment.setSenderId(resultSet.getInt("SenderUserId"));
                comment.setScore(resultSet.getDouble("Score"));
                comment.setSub(resultSet.getString("Subject"));
                comment.setText(resultSet.getString("Text"));
                return comment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertCommentForUser(Comment comment) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Comment " +
                    "(SenderUserId, Score, Subject, Text) values (?, ?, ?, ?);");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT Id From Comment" +
                    " WHERE SenderUserId = ? And Score = ? AND Subject = ? AND Text = ?");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comment.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO UserCommentForUser " +
                    "(CommentId, ReceiverUserId, ReceiverType) values (?, ?, ?);");
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setInt(2, comment.getrId());
            preparedStatement.setString(3,comment.getrType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCommentForBook(Comment comment) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into Comment " +
                    "(SenderUserId, Score, Subject, Text) values (?, ?, ?, ?);");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT Id From Comment" +
                    " WHERE SenderUserId = ? And Score = ? AND Subject = ? AND Text = ?");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comment.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO UserCommentForBook " +
                    "(CommentId, BookId) values (?, ?);");
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setInt(2, comment.getrId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCommentForBookstore(Comment comment) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into Comment " +
                    "(SenderUserId, Score, Subject, Text) values (?, ?, ?, ?);");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT Id From Comment" +
                    " WHERE SenderUserId = ? And Score = ? AND Subject = ? AND Text = ?");
            preparedStatement.setInt(1, comment.getSenderId());
            preparedStatement.setDouble(2, comment.getScore());
            preparedStatement.setString(3, comment.getSub());
            preparedStatement.setString(4, comment.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comment.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO UserCommentForBookstore " +
                    "(CommentId, BookstoreId) values (?, ?);");
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setInt(2, comment.getrId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
