package logic.Portal;

import logic.object.Book;
import logic.object.User;
import logic.object.UserHasBook;
import logic.sql_instruction.SQLInstruction;

import java.util.Vector;

public class UserPortal extends Portal {
    public UserPortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    @Override
    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsUser(username, password);
        if (ret == -1) {
            return access = false;
        }
        this.id = ret;
        return access = true;
    }

    public User getUserProfileValues(int id) {
        return sqlInstruction.getExtractor().extractUserProfileValues(id);
    }

    public int registerUser(String username, String password, String name, String surname) {
        return sqlInstruction.getRegister().registerUser(username, password, name, surname);
    }

    public boolean existUser(String username) {
        return sqlInstruction.getExists().existUser(username);
    }

    public Vector <UserHasBook> getUserBooks (int userId) {
        return sqlInstruction.getExtractor().extractUserBooks(userId);
    }

    public void addBook(int bookId, int num) {
        sqlInstruction.getUpdate().addBookForUser(id, bookId, num);
    }

    public void romoveBook(int bookId, int num) {
        sqlInstruction.getUpdate().addBookFromUser(id, bookId, num);
    }

    public void changeBookStatus(int bookId, String status) {
        sqlInstruction.getUpdate().changeBookStatus(id, bookId, status);
    }
}
