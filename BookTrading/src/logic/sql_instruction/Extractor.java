package logic.sql_instruction;

import logic.object.Book;
import logic.object.Employee;
import logic.object.User;
import logic.object.Wallet;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Extractor extends Instruction {
    public Extractor(Connection connection) {
        super(connection);
    }

    public Vector <User> extractUserTable() {
        Vector <User> ret = new Vector<User>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM User;");
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
                    "WHERE Id = ?");
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

    public Book extractBookById(int bookId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From Book " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                book.setId(resultSet.getInt("Id"));
                book.setPubid(resultSet.getInt("PublisherId"));
                book.setName(resultSet.getString("Name"));
                book.setSeries(resultSet.getInt("SeriesNumber"));
                book.setGenre(resultSet.getString(resultSet.getString("Genre")));
                book.setLang(resultSet.getString("Language"));
                book.setReleaseDate(dateFormat.format(resultSet.getDate("ReleaseDate")));
                book.setMaterial(resultSet.getString("Material"));
                book.setDes(resultSet.getString("Description"));
                book.setSum(resultSet.getString("Summary"));
                book.setCat(resultSet.getString("Category"));
                book.setSize(resultSet.getString("Size"));
                book.setScore(resultSet.getDouble("Score"));
                book.setPrice(resultSet.getDouble("Price"));
                PreparedStatement pa = connection.prepareStatement("SELECT * FROM UserCommentForBook " +
                        "Where BookId = ?;");
                pa.setInt(1, book.getId());
                ResultSet rs = pa.executeQuery();
                if (!rs.next())
                    book.setScore(-1);

                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Vector <Book> extractUserBooks(int userId) {
        Vector <Book> ret = new Vector<Book>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT BookId FROM UserHasBook " +
                    "WHERE UserId = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ret.add(extractBookById(resultSet.getInt("Id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vector <Book> extractBookTable() {
        Vector <Book> ret = new Vector<Book>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM Book;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                ret.add(extractBookById(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Wallet extractWalletById(int UserId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From Wallet " +
                    "WHERE UserId = ?");

            preparedStatement.setInt(1, UserId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Wallet wallet = new Wallet();
                wallet.setUserId(resultSet.getInt("UserId"));
                wallet.setBlockedCredit(resultSet.getDouble("BlockedCredit"));
                wallet.setAvailableCredit(resultSet.getDouble("AvailableCredit"));
                return wallet;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vector <Employee> extractEmployeeTable() {
        Vector <Employee> ret = new Vector<Employee>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM Employee;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                ret.add(extractEmployeeById(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Employee extractEmployeeById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From Employee " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("Id"));
                employee.setUsername(resultSet.getString("Username"));
                employee.setFirstName(resultSet.getString("FirstName"));
                employee.setSurname(resultSet.getString("Surname"));
                employee.setAddress(resultSet.getString("City") + ", " + resultSet.getString("Region"));
                employee.setEmail(resultSet.getString("Email"));
                employee.setTelephone(resultSet.getString("Telephone"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
