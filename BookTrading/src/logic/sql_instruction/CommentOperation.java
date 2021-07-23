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
}
