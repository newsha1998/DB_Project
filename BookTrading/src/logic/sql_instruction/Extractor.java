package logic.sql_instruction;

import logic.object.*;

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
                user.setCity(resultSet.getString("City"));
                user.setRegion(resultSet.getString("Region"));
                user.setStreet(resultSet.getString("Street"));
                user.setAlley(resultSet.getString("Alley"));
                user.setHouseNumber(resultSet.getString("HouseNumber"));
                user.setNational(resultSet.getString("NationalId"));
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
                book.setSeries(resultSet.getString("SeriesNumber"));
                book.setGenre(resultSet.getString("Genre"));
                book.setLang(resultSet.getString("Language"));
                book.setReleaseDate(String.valueOf(resultSet.getDate("ReleaseDate")));
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

                Vector <Integer> authors = new Vector<Integer>();
                pa = connection.prepareStatement("SELECT AuthorId FROM AuthorBook WHERE BookId = ?;");
                pa.setInt(1, book.getId());
                rs = pa.executeQuery();
                while (rs.next()) {
                    authors.add(rs.getInt("AuthorId"));
                }
                book.setAuthors(authors);

                Vector <Integer> interpreters = new Vector<Integer>();
                pa = connection.prepareStatement("SELECT InterpreterId FROM InterpreterBook WHERE BookId = ?;");
                pa.setInt(1, book.getId());
                rs = pa.executeQuery();
                while (rs.next()) {
                    interpreters.add(rs.getInt("InterpreterId"));
                }
                book.setInterpreters(interpreters);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Vector <UserHasBook> extractUserBooks(int userId) {
        Vector <UserHasBook> ret = new Vector<UserHasBook>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM UserHasBook " +
                    "WHERE UserId = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book b = extractBookById(resultSet.getInt("BookId"));
                ret.add(new UserHasBook(b.getId(), b.getName(), resultSet.getInt("Number"),
                        resultSet.getString("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
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

    public Vector<Author> extractAuthors() {
        Vector <Author> ret = new Vector<Author>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, FirstName, Surname" +
                    " FROM Author;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author a = new Author(resultSet.getInt("Id"), resultSet.getString("FirstName"),
                        resultSet.getString("Surname"));
                ret.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Vector<Author> extractInterpreters() {
        Vector <Author> ret = new Vector<Author>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, FirstName, Surname" +
                    " FROM Interpreter;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author a = new Author(resultSet.getInt("Id"), resultSet.getString("FirstName"),
                        resultSet.getString("Surname"));
                ret.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Vector<Publisher> extractPublisher() {
        Vector <Publisher> ret = new Vector<Publisher>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT RegistrationNumber, Name " +
                    " FROM Publisher;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Publisher a = new Publisher(resultSet.getInt("RegistrationNumber"), resultSet.getString("Name"));
                ret.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public String getPublisherName(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT Name FROM Publisher " +
                    "WHERE RegistrationNumber = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAuthorName(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Author " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("FirstName") + " " + resultSet.getString("Surname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getInterpreterName(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Interpreter " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("FirstName") + " " + resultSet.getString("Surname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vector<Book> extractSimilarBookTable(String name) {
        Vector <Book> ret = new Vector<Book>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM Book WHERE  " +
                    "Name LIKE ?;");
            preparedStatement.setString(1, "%" + name + "%");
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

    public int extractUserIdByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM User Where Username = ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt("Id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Vector<Advertisement> extractAdvertisements() {
        Vector <Advertisement> ret = new Vector<Advertisement>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Advertisement");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertisement ads = new Advertisement();
                ads.setId(resultSet.getInt("Id"));
                ads.setBookId(resultSet.getInt("BookId"));
                ads.setDescription(resultSet.getString("Description"));
                ads.setUserId(resultSet.getInt("UserId"));
                ads.setProposedPrice(resultSet.getDouble("ProposedPrice"));
                ads.setTitle(resultSet.getString("Title"));

                preparedStatement = connection.prepareStatement("SELECT Username FROM User " +
                        "WHERE Id = ?");
                preparedStatement.setInt(1, resultSet.getInt("UserId"));
                ResultSet res = preparedStatement.executeQuery();
                if (res.next())
                    ads.setUsername(res.getString("Username"));

                ret.add(ads);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Vector<Advertisement> extractUserAdvertisements(int id) {
        Vector <Advertisement> ret = new Vector<Advertisement>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Advertisement " +
                    "WHERE UserId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertisement ads = new Advertisement();
                ads.setId(resultSet.getInt("Id"));
                ads.setBookId(resultSet.getInt("BookId"));
                ads.setDescription(resultSet.getString("Description"));
                ads.setUserId(resultSet.getInt("UserId"));
                ads.setProposedPrice(resultSet.getDouble("ProposedPrice"));
                ads.setTitle(resultSet.getString("Title"));

                ret.add(ads);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Bookstore extractBookstoreById (int id) {
        Bookstore bookstore = new Bookstore();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Bookstore " +
                    "WHERE Id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookstore.setId(id);
                bookstore.setUsername(resultSet.getString("Username"));
                bookstore.setName(resultSet.getString("Name"));
                bookstore.setWebsite(resultSet.getString("Website"));
                bookstore.setScore(resultSet.getDouble("Score"));
                bookstore.setCity(resultSet.getString("City"));
                bookstore.setRegion(resultSet.getString("Region"));
                bookstore.setStreet(resultSet.getString("Street"));
                bookstore.setAlley(resultSet.getString("Alley"));
                bookstore.setBuilding(resultSet.getString("BuildingNumber"));
                bookstore.setEmail(resultSet.getString("Email"));
                PreparedStatement pr = connection.prepareStatement("SELECT * FROM UserCommentForBookstore " +
                        "WHERE BookstoreId = ?");
                pr.setInt(1, bookstore.getId());
                ResultSet rs = pr.executeQuery();
                if (!rs.next()) {
                    bookstore.setScore(-1);
                }
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM BookstoreTelephone WHERE " +
                    "BookstoreId = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookstore.addPhone(resultSet.getString("Telephone"));
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM BookstoreHasBook Where " +
                    "BookstoreId = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookstore.addBook(new BookstoreHasBook(id, resultSet.getInt("BookId"),
                        resultSet.getInt("Number"), resultSet.getDouble("Price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookstore;
    }

    public Vector <Bookstore> extractAllBookstores () {
        Vector <Bookstore> bookstores = new Vector<Bookstore>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id FROM Bookstore;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookstores.add(extractBookstoreById(resultSet.getInt("Id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookstores;
    }

}
