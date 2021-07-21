package logic.Portal;

import logic.object.User;
import logic.sql_instruction.SQLInstruction;

public class UserPortal extends Portal {
    public UserPortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    public User getUserProfileValues(int id) {
        return sqlInstruction.extractUserProfileValues(id);
    }
}
