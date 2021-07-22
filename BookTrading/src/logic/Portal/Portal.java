package logic.Portal;

import logic.object.User;
import logic.object.UserHasBook;
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
}
