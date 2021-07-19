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

    public String getUserName(int id) throws SQLException {
        preparedStatement =  connection.prepareStatement("SELECT * FROM User WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("FirstName") + " " + resultSet.getString("Surname");
        }
        return null;
    }

    public String getEmployeeName(int id) throws SQLException {
        preparedStatement =  connection.prepareStatement("SELECT * FROM Employee WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("FirstName") + " " + resultSet.getString("Surname");
        }
        return null;
    }

    public String getManagerName(int id) throws SQLException {
        preparedStatement =  connection.prepareStatement("SELECT * FROM Manager WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("FirstName") + " " + resultSet.getString("Surname");
        }
        return null;
    }

    public String getBookstoreName(int id) throws SQLException {
        preparedStatement =  connection.prepareStatement("SELECT * FROM Bookstore WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("Name");
        }
        return null;
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

    public void AddBook(int PublisherId, String Name, double Price,
                        String Genre, String Language, Date ReleaseDate,
                        String Material, int SeriesNumber, String Description,
                        String Summary, String Category, String Size) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Book (PublisherId, Name, Price, Genre, Language, ReleaseDate, Material, SeriesNumber, String Description, Summary, Category, Size) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, PublisherId);
        preparedStatement.setString(2, Name);
        preparedStatement.setDouble(3, Price);
        preparedStatement.setString(4, Genre);
        preparedStatement.setString(5, Language);
        preparedStatement.setDate(6, ReleaseDate);
        preparedStatement.setString(7, Material);
        preparedStatement.setInt(8, SeriesNumber);
        preparedStatement.setString(9, Description);
        preparedStatement.setString(10, Summary);
        preparedStatement.setString(11, Category);
        preparedStatement.setString(12, Size);
        preparedStatement.executeUpdate();
    }





    public void AddAuthor(String FirstName, String Surname, String Nationality, Date BirthDate,
                          Date DeathDate, String WritingStyle, String Doctrine,
                          String City, String Region, String Street, String Alley,
                          String HouseNumber, String Telephone, String Description) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Author (FirstName, Surname, Nationality, BirthDate, DeathDate, WritingStyle, Doctrine, City, Region, Street, Alley, HouseNumber, Telephone, Description) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.setString(3, Nationality);
        preparedStatement.setDate(4, BirthDate);
        preparedStatement.setDate(5, DeathDate);
        preparedStatement.setString(6, WritingStyle);
        preparedStatement.setString(7, Doctrine);
        preparedStatement.setString(8, City);
        preparedStatement.setString(9, Region);
        preparedStatement.setString(10, Street);
        preparedStatement.setString(11, Alley);
        preparedStatement.setString(12, HouseNumber);
        preparedStatement.setString(13, Telephone);
        preparedStatement.setString(14, Description);
        preparedStatement.executeUpdate();
    }



    public void AddInterpreter(String FirstName, String Surname, String Nationality, Date BirthDate,
                               Date DeathDate, String Style,String City,
                               String Region, String Street, String Alley,
                               String HouseNumber, String Telephone, String Description) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Interpreter(FirstName, Surname, Nationality, BirthDate, DeathDate, Style, City, Region, Street, Alley, HouseNumber, Telephone, Description) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.setString(3, Nationality);
        preparedStatement.setDate(4, BirthDate);
        preparedStatement.setDate(5, DeathDate);
        preparedStatement.setString(6, Style);
        preparedStatement.setString(7, City);
        preparedStatement.setString(8, Region);
        preparedStatement.setString(9, Street);
        preparedStatement.setString(10, Alley);
        preparedStatement.setString(11, HouseNumber);
        preparedStatement.setString(12, Telephone);
        preparedStatement.setString(13, Description);
        preparedStatement.executeUpdate();
    }

    public void AddInterpreter(String FirstName, String Surname) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Interpreter(FirstName, Surname) \n" +
                "VALUES (?, ?)");
        preparedStatement.setString(1, FirstName);
        preparedStatement.setString(2, Surname);
        preparedStatement.executeUpdate();
    }


    public void AddPublisher(int RegistrationNumber, String Name, String City,
                             String Region, String Street, String Alley, String HouseNumber) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Publisher(RegistrationNumber, Name, City, Region, Street, Alley, City, Region, Street, Alley, HouseNumber) \n" +
                "V‏ALUES (?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, RegistrationNumber);
        preparedStatement.setString(2, Name);
        preparedStatement.setString(3, City);
        preparedStatement.setString(4, Region);
        preparedStatement.setString(5, Street);
        preparedStatement.setString(6, Alley);
        preparedStatement.setString(7, HouseNumber);
        preparedStatement.executeUpdate();
    }

    public void AddPublisher(String Name) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Publisher( Namer) \n" +
                "V‏ALUES (?)");

        preparedStatement.setString(1, Name);
        preparedStatement.executeUpdate();
    }


    public void AddMessage(int ReceiverUserid, int SenderUserId, String Subject, String Text) throws SQLException {
        preparedStatement =  connection.prepareStatement("INSERT INTO Message(ReceiverUserid, SenderUserId, Subject, Text) \n" +
                "VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, ReceiverUserid);
        preparedStatement.setInt(2, SenderUserId);
        preparedStatement.setString(3, Subject);
        preparedStatement.setString(4, Text);
        preparedStatement.executeUpdate();
    }

    public void AddComplaint(String Subject, String Text, String Documentation) throws SQLException {
        preparedStatement =  connection.prepareStatement("INSERT INTO Complaint(Subject, Text, Documentation) \n" +
                "VALUES (?, ?, ?)");
        preparedStatement.setString(1, Subject);
        preparedStatement.setString(2, Text);
        preparedStatement.setString(3, Documentation);
        preparedStatement.executeUpdate();

    }


    public void AddComplaintUser(int PlaintiffId, int UserId) throws SQLException {
        preparedStatement =  connection.prepareStatement("INSERT INTO ComplaintUser(PlaintiffId, UserId) \n" +
                "VALUES (?, ?)");
        preparedStatement.setInt(1, PlaintiffId);
        preparedStatement.setInt(2, UserId);
        preparedStatement.executeUpdate();
    }

    public void AddComplaintBookstore(int PlaintiffId, int BookstoreId) throws SQLException {
        preparedStatement =  connection.prepareStatement("INSERT INTO ComplaintBookstore(PlaintiffId, BookstoreId) \n" +
                "VALUES (?, ?)");
        preparedStatement.setInt(1, PlaintiffId);
        preparedStatement.setInt(2, BookstoreId);
        preparedStatement.executeUpdate();
    }

    public int AddBorrowReq(int BorrowerId, int LenderId, int BookId, double Price,
                            Date StartDate, Date DeadlineDate, double DailyDelayPenalty,
                            double GuaranteePrice, String DeliveryAddress, String Description) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO Borrow(BorrowerId, LenderId, BookId, Price, StartDate, DeadlineDate, DailyDelayPenalty, GuaranteePrice, DeliveryAddress, Description) \n" +
                "V‏ALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, BorrowerId);
        preparedStatement.setInt(2, LenderId);
        preparedStatement.setInt(3, BookId);
        preparedStatement.setDouble(4, Price);
        preparedStatement.setDate(5, StartDate);
        preparedStatement.setDate(6, DeadlineDate);
        preparedStatement.setDouble(7, DailyDelayPenalty);
        preparedStatement.setDouble(8, GuaranteePrice);
        preparedStatement.setString(9, DeliveryAddress);
        preparedStatement.setString(10, Description);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("SELECT Id FROM Borrow WHERE BorrowerId = ? and LenderId = ? and BookId = ? and  Price = ? and StartDate = ? and DeadlineDate = ? and DailyDelayPenalty = ? and GuaranteePrice = ? and DeliveryAddress = ? and Description = ? and Confirmation = 0");
        ResultSet resultSet = preparedStatement.executeQuery();

        return  resultSet.getInt("Id");

    }


}
