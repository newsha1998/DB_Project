package logic.sql_instruction;

import logic.object.User;

import java.sql.*;
import java.util.Vector;

public class Extractor extends Instruction {
    public Extractor(Connection connection) {
        super(connection);
    }

    public Vector <User> extractUserTable() {
        Vector <User> ret = new Vector<User>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM User;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                ret.add(extractUserProfileValues(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public User extractUserProfileValues(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From User " +
                    "WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("Id"));
                user.setUsername(resultSet.getString("Username"));
                user.setName(resultSet.getString("FirstName"));
                user.setSurname(resultSet.getString("Surname"));
                user.setAddress(resultSet.getString("City") + ", " + resultSet.getString("Region"));
                user.setEmail(resultSet.getString("Email"));
                user.setTelephone(resultSet.getString("Telephone"));
                user.setSeller(resultSet.getDouble("ScoreAsSeller"));
                user.setLender(resultSet.getDouble("ScoreAsLender"));
                user.setBorrower(resultSet.getDouble("ScoreAsBorrower"));
                user.setPurchaser(resultSet.getDouble("ScoreAsPurchaser"));
                PreparedStatement pa = connection.prepareStatement("SELECT * FROM UserCommentForUser " +
                        "Where ReceiverUserId = ? AND ReceiverType = ?;");
                pa.setInt(1, user.getId());
                pa.setString(2, "Seller");
                ResultSet rs = pa.executeQuery();
                if (!rs.next())
                    user.setSeller(-1);
                pa.setString(2, "Lender");
                rs = pa.executeQuery();
                if (!rs.next())
                    user.setLender(-1);
                pa.setString(2, "Borrower");
                rs = pa.executeQuery();
                if (!rs.next())
                    user.setBorrower(-1);
                pa.setString(2, "Purchaser");
                rs = pa.executeQuery();
                if (!rs.next())
                    user.setPurchaser(-1);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
