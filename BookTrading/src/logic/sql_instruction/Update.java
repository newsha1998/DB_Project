package logic.sql_instruction;

import logic.Manager;

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

    public void UpdateUserFirstName(String username, String name){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET FirstName = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserSurname(String username, String surname) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Surname = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserCity(String username, String city) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET City = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserRegion(String username, String region) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Region = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, region);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserAlley(String username, String alley) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Alley = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, alley);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserHouseNo(String username, String no) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET HouseNumber = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, no);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserStreet(String username, String street) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Street = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, street);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserEmail(String username, String email) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Email = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateUserPhone(String username, String phone) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("UPDATE User SET Telephone = ? " +
                    "WHERE Username = ?");
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void RemoveAdvertisement(int id) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("delete from  Advertisement " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateManager(Manager manager) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET FirstName = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getFirstname());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Surname = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getSurname());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET NationalId = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getNationalId());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Email = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getEmail());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET City = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getCity());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Region = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getRegion());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Street = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getStreet());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Alley = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getAlley());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET HouseNumber = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getHousenumber());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE Manager " +
                    "SET Telephone = ? WHERE Id = ?;");
            preparedStatement.setString(1, manager.getTelephone());
            preparedStatement.setInt(2, manager.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
