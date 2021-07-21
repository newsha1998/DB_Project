package logic.Portal;

import logic.object.User;
import logic.sql_instruction.SQLInstruction;

public class UserPortal extends Portal {
    public UserPortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    public User getUserProfileValues(int id) {
        return sqlInstruction.getExtractor().extractUserProfileValues(id);
    }

    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsUser(username, password);
        if (ret == -1) {
            return false;
        }
        id = ret;
        return true;
    }
}
