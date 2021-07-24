package logic.sql_instruction;

import logic.object.Borrow;
import logic.object.Buy;


import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;


public class BuyOperation extends Instruction {
    public BuyOperation(Connection connection) {
        super(connection);
    }

    public void ConfirmBuy(Buy buy){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("update  Buy " +
                    "set Success = ? , Date = ? where Id = ?");
            preparedStatement.setBoolean(1, true);
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(3, buy.getId());
            preparedStatement.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vector<Buy> getBuyRequests(int id) {
        Vector<Buy> ret = new Vector<Buy>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM userBuy " +
                    "WHERE SellerId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                preparedStatement = connection.prepareStatement("SELECT * FROM Buy " +
                        "WHERE Id = ?");
                preparedStatement.setInt(1, resultSet.getInt("Id"));
                ResultSet res = preparedStatement.executeQuery();

                if(res.next() && res.getBoolean("Success") == false){
                    Buy buy = new Buy();
                    buy.setId(resultSet.getInt("Id"));
                    buy.setBuyerId(resultSet.getInt("BuyerId"));
                    buy.setBookId(resultSet.getInt("BookId"));
                    buy.setDeliveryAddress(resultSet.getString("DeliveryAddress"));
                    buy.setPrice(res.getDouble("BookPrice"));
                    buy.setDescription(res.getString("Description"));
                    buy.setDate(String.valueOf(res.getDate("Date")));

                    preparedStatement = connection.prepareStatement("SELECT Username FROM User " +
                            "WHERE Id = ?");
                    preparedStatement.setInt(1, resultSet.getInt("BuyerId"));
                    ResultSet result = preparedStatement.executeQuery();
                    if (result.next())
                        buy.setBuyerUsername(result.getString("Username"));


                    ret.add(buy);
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ret;
    }

    public void AddBuyFromUser(Buy buy) {
        PreparedStatement preparedStatement = null;
        int sellerId = 0;
        int id = 0;
        try{
            preparedStatement = connection.prepareStatement("insert into Buy " +
                    "(Date, BookPrice, Success, Description) values (convert (?, Date), ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setDouble(2, buy.getPrice());
            preparedStatement.setBoolean(3, false);
            preparedStatement.setString(4, buy.getDescription());
            preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();
            if (res.next()) {
                id = res.getInt(1);
                buy.setId(id);
                buy.setDate(String.valueOf(LocalDate.now()));
                buy.setSuccess(false);
            }

            preparedStatement = connection.prepareStatement("SELECT Id FROM User " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, buy.getSellerUserName());
            ResultSet result = preparedStatement.executeQuery();
            if (result.next())
                sellerId = result.getInt("Id");

            preparedStatement = connection.prepareStatement("insert into UserBuy " +
                    "(Id, BuyerId, SellerId, BookId, DeliveryAddress) values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, buy.getBuyerId());
            preparedStatement.setInt(3, sellerId);
            preparedStatement.setInt(4, buy.getBookId());
            preparedStatement.setString(5, buy.getDeliveryAddress());

            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
