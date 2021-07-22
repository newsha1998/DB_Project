package logic.sql_instruction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends Instruction {
    public Update(Connection connection) {
        super(connection);
    }

    public void addBookForUser(int id, int bookId, int num) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserHasBook " +
                    "WHERE UserId = ? AND BookId = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int pre = resultSet.getInt("Number");
                PreparedStatement pr = connection.prepareStatement("UPDATE UserHasBook " +
                        "SET Number = ? WHERE UserId = ? AND BookId = ?;");
                pr.setInt(1, num + pre);
                pr.setInt(2, id);
                pr.setInt(3, bookId);
                pr.executeUpdate();
            } else {
                PreparedStatement pr = connection.prepareStatement("INSERT INTO UserHasBook " +
                        "(UserId, BookId, Number) VALUES (?, ?, ?);");
                pr.setInt(1, id);
                pr.setInt(2, bookId);
                pr.setInt(3, num);
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBookFromUser(int id, int bookId, int num) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserHasBook " +
                    "WHERE UserId = ? AND BookId = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int pre = resultSet.getInt("Number");
                if (pre > num) {
                    PreparedStatement pr = connection.prepareStatement("UPDATE UserHasBook " +
                            "SET Number = ? WHERE UserId = ? AND BookId = ?;");
                    pr.setInt(1, pre - num);
                    pr.setInt(2, id);
                    pr.setInt(3, bookId);
                    pr.executeUpdate();
                } else {
                    PreparedStatement pr = connection.prepareStatement("DELETE FROM UserHasBook " +
                            "WHERE UserId = ? And BookId = ?;");
                    pr.setInt(1, id);
                    pr.setInt(2, bookId);
                    pr.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeBookStatus(int id, int bookId, String status) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE UserHasBook " +
                    "SET Status = ? " +
                    "WHERE UserId = ? AND BookId = ?;");
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}