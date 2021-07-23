package logic.sql_instruction;

import logic.object.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class BorrowOperation extends Instruction {
    public BorrowOperation(Connection connection) {
        super(connection);
    }


    public int AddBorrowReq(int BorrowerId, String LenderUsername, int BookId, double Price, String StartDate, String DeadlineDate, double DailyDelayPenalty,
                            double GuaranteePrice, String DeliveryAddress, String Description) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        int lenderId = 0;
        try{
            preparedStatement = connection.prepareStatement("SELECT Id FROM User " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, LenderUsername);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
                lenderId = resultSet.getInt("Id");
            else
                return -1;

            preparedStatement = connection.prepareStatement("SELECT * FROM Book " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, BookId);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next())
                return -2;


            preparedStatement = connection.prepareStatement("INSERT INTO Borrow" +
                    "(BorrowerId, LenderId, BookId, Price, StartDate, DeadlineDate, DailyDelayPenalty, GuaranteePrice, " +
                    "DeliveryAddress, Description, Confirmation) " +
                    "VALUES (?, ?, ?, ?, CONVERT(?, DATE), convert(?, date), ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, BorrowerId);
            preparedStatement.setInt(2, lenderId);
            preparedStatement.setInt(3, BookId);
            preparedStatement.setDouble(4, Price);
            preparedStatement.setString(5, StartDate);
            preparedStatement.setString(6, DeadlineDate);
            preparedStatement.setDouble(7, DailyDelayPenalty);
            preparedStatement.setDouble(8, GuaranteePrice);
            preparedStatement.setString(9, DeliveryAddress);
            preparedStatement.setString(10, Description);
            preparedStatement.setBoolean(11, false);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -3;
    }

    public void BorrowConfirmation(int borrowId) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE Borrow SET Confirmation = true where Id = ?");
            preparedStatement.setInt(1, borrowId);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE Borrow SET Status = ? where Id = ?");
            preparedStatement.setString(1, "Borrowed");
            preparedStatement.setInt(2, borrowId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Vector<Borrow> getBorrowRequests(int userId){
        PreparedStatement preparedStatement = null;
        Vector<Borrow> vector = new Vector<>();
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Borrow " +
                    "WHERE LenderId = ? AND Confirmation = false ");
            preparedStatement.setInt(1, userId);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){
                Borrow borrow = new Borrow(res.getInt("Id"));

                borrow.setBookId(res.getInt("BookId"));
                borrow.setDescription(res.getString("Description"));
                borrow.setPrice(res.getDouble("Price"));
                borrow.setBorrowerId(res.getInt("BorrowerId"));
                borrow.setDailyDelayPenalty(res.getDouble("DailyDelayPenalty"));
                borrow.setDeliveryAddress(res.getString("DeliveryAddress"));
                borrow.setGuaranteePrice(res.getDouble("GuaranteePrice"));
                borrow.setStartDate(String.valueOf(res.getDate("StartDate")));
                borrow.setDeadlineDate(String.valueOf(res.getDate("DeadlineDate")));

                preparedStatement = connection.prepareStatement("SELECT Username FROM User " +
                        "WHERE Id = ?");
                preparedStatement.setInt(1, res.getInt("BorrowerId"));
                ResultSet result = preparedStatement.executeQuery();
                if(result.next()){
                    borrow.setBorrowerUsername(result.getString("Username"));
                }

                vector.add(borrow);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vector;
    }

}
