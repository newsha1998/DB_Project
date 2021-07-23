package logic.sql_instruction;

import logic.object.Book;

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
                        "Name = ? AND Genre = ? AND Language = ? AND Material = ? AND SeriesNumber = ? AND Description = ? AND Summary = ? AND Category = ? AND Size = ? AND PublisherId = ? AND ReleaseDate = CONVERT (?, DATE));");
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
                        "(BookId, AuthorId) VALUES (?, ?);");
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
}
