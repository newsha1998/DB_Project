package logic.sql_instruction;

import logic.object.Book;
import logic.object.Complaint;
import logic.object.Employee;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert extends Instruction {
    public Insert(Connection connection) {
        super(connection);
    }

    public boolean insertBook (Book book) {
        try {
            if (book.getPubid() == 0 && book.getReleaseDate().equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book " +
                        "(Name, Genre, Language, Material, SeriesNumber, Description, Summary, Category, Size) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("SELECT Id FROM Book WHERE " +
                        "Name = ? AND Genre = ? AND Language = ? AND Material = ? AND SeriesNumber = ? AND Description = ? AND Summary = ? AND Category = ? AND Size = ?;");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    book.setId(resultSet.getInt("Id"));
                }
            } else  if (book.getPubid() != 0 && book.getReleaseDate().equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book " +
                        "(Name, Genre, Language, Material, SeriesNumber, Description, Summary, Category, Size, PublisherId) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setInt(10, book.getPubid());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("SELECT Id FROM Book WHERE " +
                        "Name = ? AND Genre = ? AND Language = ? AND Material = ? AND SeriesNumber = ? AND Description = ? AND Summary = ? AND Category = ? AND Size = ? AND PublisherId = ?;");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setInt(10, book.getPubid());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    book.setId(resultSet.getInt("Id"));
                }
            } else  if (book.getPubid() != 0 && !book.getReleaseDate().equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book " +
                        "(Name, Genre, Language, Material, SeriesNumber, Description, Summary, Category, Size, PublisherId, ReleaseDate) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CONVERT (?, DATE));");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setInt(10, book.getPubid());
                preparedStatement.setString(11, book.getReleaseDate());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("SELECT Id FROM Book WHERE " +
                        "Name = ? AND Genre = ? AND Language = ? AND Material = ? AND SeriesNumber = ? AND Description = ? AND Summary = ? AND Category = ? AND Size = ? AND PublisherId = ? AND ReleaseDate = CONVERT (?, DATE);");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setInt(10, book.getPubid());
                preparedStatement.setString(11, book.getReleaseDate());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    book.setId(resultSet.getInt("Id"));
                }
            } else  if (book.getPubid() == 0 && !book.getReleaseDate().equals("")) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book " +
                        "(Name, Genre, Language, Material, SeriesNumber, Description, Summary, Category, Size, ReleaseDate) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CONVERT (?, DATE));");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setString(10, book.getReleaseDate());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("SELECT Id FROM Book WHERE " +
                        "Name = ? AND Genre = ? AND Language = ? AND Material = ? AND SeriesNumber = ? AND Description = ? AND Summary = ? AND Category = ? AND Size = ? AND ReleaseDate = CONVERT (?, DATE);");
                preparedStatement.setString(1, book.getName());
                preparedStatement.setString(2, book.getGenre());
                preparedStatement.setString(3, book.getLang());
                preparedStatement.setString(4, book.getMaterial());
                preparedStatement.setString(5, book.getSeries());
                preparedStatement.setString(6, book.getDes());
                preparedStatement.setString(7, book.getSum());
                preparedStatement.setString(8, book.getCat());
                preparedStatement.setString(9, book.getSize());
                preparedStatement.setString(10, book.getReleaseDate());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    book.setId(resultSet.getInt("Id"));
                }
            }

            for (int i : book.getAuthors()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AuthorBook " +
                        "(BookId, AuthorId) VALUES (?, ?);");
                preparedStatement.setInt(1, book.getId());
                preparedStatement.setInt(2, i);
                preparedStatement.executeUpdate();
            }

            for (int i : book.getInterpreters()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO InterpreterBook " +
                        "(BookId, InterpreterId) VALUES (?, ?);");
                preparedStatement.setInt(1, book.getId());
                preparedStatement.setInt(2, i);
                preparedStatement.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void AddAdvertisement(int userId, String title, Integer bookId, Double price, String description) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO Advertisement" +
                    "(BookId, UserId, Title, ProposedPrice, Description) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1,bookId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, title);
            preparedStatement.setDouble(4, price);
            preparedStatement.setString(5, description);
            preparedStatement.executeUpdate();


        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUserComplaint(Complaint complaint) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Complaint " +
                    "(Subject, Text, Documentation) VALUES  (?, ?, ?);");
            preparedStatement.setString(1, complaint.getSub());
            preparedStatement.setString(2, complaint.getText());
            preparedStatement.setString(3, complaint.getDoc());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT * FROM Complaint WHERE " +
                    "Subject = ? AND Text = ? AND Documentation = ?");
            preparedStatement.setString(1, complaint.getSub());
            preparedStatement.setString(2, complaint.getText());
            preparedStatement.setString(3, complaint.getDoc());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                complaint.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO ComplaintUser (ComplaintId, PlaintiffId, UserId) " +
                    "VALUES (?, ?, ?)");
            preparedStatement.setInt(1, complaint.getId());
            preparedStatement.setInt(2, complaint.getPlaintiffId());
            preparedStatement.setInt(3, complaint.getrId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBookstoreComplaint(Complaint complaint) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Complaint " +
                    "(Subject, Text, Documentation) VALUES  (?, ?, ?);");
            preparedStatement.setString(1, complaint.getSub());
            preparedStatement.setString(2, complaint.getText());
            preparedStatement.setString(3, complaint.getDoc());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT * FROM Complaint WHERE " +
                    "Subject = ? AND Text = ? AND Documentation = ?");
            preparedStatement.setString(1, complaint.getSub());
            preparedStatement.setString(2, complaint.getText());
            preparedStatement.setString(3, complaint.getDoc());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                complaint.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO ComplaintBookstore (ComplaintId, PlaintiffId, BookstoreId) " +
                    "VALUES (?, ?, ?)");
            preparedStatement.setInt(1, complaint.getId());
            preparedStatement.setInt(2, complaint.getPlaintiffId());
            preparedStatement.setInt(3, complaint.getrId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSupporter(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee " +
                    "(Username, FirstName, Surname, Password) values (?, ?, ?, ?);");
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getSurname());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT Id FROM Employee WHERE Username = ?;");
            preparedStatement.setString(1, employee.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO SupportAgent (EmployeeId) value (?);");
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAccountant(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee " +
                    "(Username, FirstName, Surname, Password) values (?, ?, ?, ?);");
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getSurname());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("SELECT Id FROM Employee WHERE Username = ?;");
            preparedStatement.setString(1, employee.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("Id"));
            }
            preparedStatement = connection.prepareStatement("INSERT INTO Accountant (EmployeeId) value (?);");
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPhoneForBookstore(int id, String phone) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into BookstoreTelephone " +
                    "(BookstoreId, Telephone) values (?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, phone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBookForBookstore(int id, int bookId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BookstoreHasBook " +
                    "WHERE BookstoreId = ? And BookId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                PreparedStatement pr = connection.prepareStatement("Insert into BookstoreHasBook (bookstoreid, bookid)  values (?, ?)");
                pr.setInt(1, id);
                pr.setInt(2, bookId);
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
