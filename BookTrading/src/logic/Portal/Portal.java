package logic.Portal;

import logic.object.*;
import logic.sql_instruction.SQLInstruction;

import java.util.Vector;

public abstract class Portal {
    SQLInstruction sqlInstruction;
    boolean access;
    int id;
    String name;

    public Portal(SQLInstruction sqlInstruction) {
        this.sqlInstruction = sqlInstruction;
        access = false;
    }

    public abstract boolean login(String username, String password);

    public int getId() {
        return id;
    }

    public Vector<User> getAllUsers() {
        return sqlInstruction.getExtractor().extractUserTable();
    }

    public User getUserProfileValues(int id) {
        return sqlInstruction.getExtractor().extractUserProfileValues(id);
    }

    public Vector <UserHasBook> getUserBooks (int userId) {
        return sqlInstruction.getExtractor().extractUserBooks(userId);
    }

    public Vector<Author> getAuthors() {
        return sqlInstruction.getExtractor().extractAuthors();
    }

    public Vector<Author> getInterpreters() {
        return sqlInstruction.getExtractor().extractInterpreters();
    }

    public Vector<Publisher> getPublishers() {
        return sqlInstruction.getExtractor().extractPublisher();
    }

    public String getAuthorName (int id) {
        return sqlInstruction.getExtractor().getAuthorName(id);
    }

    public String getInterpreterName (int id) {
        return sqlInstruction.getExtractor().getInterpreterName(id);
    }

    public String getPublisherName (int id) {
        return sqlInstruction.getExtractor().getPublisherName(id);
    }

    public boolean insertBook(Book book) {
        return sqlInstruction.getInsert().insertBook(book);
    }
}
