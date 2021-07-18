package Logic;

import com.sun.org.apache.xpath.internal.objects.XNull;

import javax.lang.model.type.NullType;
import java.sql.*;

public class Instructions {
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    public Instructions(Connection con) throws SQLException {
        connection = con;
        statement = connection.createStatement();
    }

    public boolean loginAsUser(int id, String pass) throws SQLException {
        boolean res = false;
        preparedStatement =  connection.prepareStatement("SELECT Password FROM User WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (pass.equals(resultSet.getString("Password")))
                res = true;
        }
        return res;
    }

    public boolean loginAsManager(int id, String pass) throws SQLException {
        boolean res = false;
        preparedStatement =  connection.prepareStatement("SELECT Password FROM Manager WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (pass.equals(resultSet.getString("Password")))
                res = true;
        }
        return res;
    }

    public boolean loginAsEmployee(int id, String pass) throws SQLException {
        boolean res = false;
        preparedStatement =  connection.prepareStatement("SELECT Password FROM Employee WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (pass.equals(resultSet.getString("Password")))
                res = true;
        }
        return res;
    }

    public boolean loginAsBookstore(int id, String pass) throws SQLException {
        boolean res = false;
        preparedStatement =  connection.prepareStatement("SELECT Password FROM Bookstore WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (pass.equals(resultSet.getString("Password")))
                res = true;
        }
        return res;
    }

    public void addUserAccount(int national, String name, String surname, String pass, String email,
                               String credit, String city, String Region, String street, String alley,
                               String no, String tell) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO User (NationalId, FirstName, Surname, Email, Password, CreditCardNumber, City, Region, Street, Alley, HouseNumber, Telephone) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, national);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, surname);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, pass);
        preparedStatement.setString(6, credit);
        preparedStatement.setString(7, city);
        preparedStatement.setString(8, Region);
        preparedStatement.setString(9, street);
        preparedStatement.setString(10, alley);
        preparedStatement.setString(11, no);
        preparedStatement.setString(12, tell);
        preparedStatement.executeUpdate();
    }

    public void addUserAccount(String name, String surname, String pass) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO User (FirstName, Surname, Password) \n" +
                "VALUES (?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, pass);
        preparedStatement.executeUpdate();
    }

    public void AddManagerAccount(int NationalId, String FirstName, String Surname, String Email,
                                  String Password, String City, String Region, String Street, String Alley,
                                  String HousNumber, String Telephone) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Manager (NationalId, FirstName, Surname, Email, Password, CreditCardNumber, City, Region, Street, Alley, HouseNumber, Telephone) \n" +
                "V‏ALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, NationalId);
        preparedStatement.setString(2, FirstName);
        preparedStatement.setString(3, Surname);
        preparedStatement.setString(4, Email);
        preparedStatement.setString(5, Password);
        preparedStatement.setString(6, City);
        preparedStatement.setString(7, Region);
        preparedStatement.setString(8, Street);
        preparedStatement.setString(9, Alley);
        preparedStatement.setString(10, HousNumber);
        preparedStatement.setString(11, Telephone);
        preparedStatement.executeUpdate();
    }

    public void AddManagerAccount(String FirstName, String Surname, String Password) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Manager (FirstName, Surname, Password) \n" +
                "VALUES (?, ?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.setString(3, Password);
        preparedStatement.executeUpdate();
    }

    public void AddEmployeeAccount(String FirstName, String Surname, String Password) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Employee (FirstName, Surname, Password) \n" +
                "VALUES (?, ?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.setString(3, Password);
        preparedStatement.executeUpdate();
    }


    public void AddBookstoreAccount(String name, String Password) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Bookstore (Name, Password) \n" +
                "VALUES (?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, Password);
        preparedStatement.executeUpdate();
    }

    public void AddBook(String name) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Book (Name) \n" +
                "VALUES (?)");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }




    public void AddAuthor(String FirstName, String Surname) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Author(FirstName, Surname) \n" +
                "VALUES (?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.setString(2, Surname);
        preparedStatement.executeUpdate();
    }
}
