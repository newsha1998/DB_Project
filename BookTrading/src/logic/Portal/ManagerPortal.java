package logic.Portal;

import logic.sql_instruction.SQLInstruction;

public class ManagerPortal extends Portal {
    public ManagerPortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    @Override
    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsManager(username, password);
        if (ret == -1) {
            return access = false;
        }
        this.id = ret;
        return access = true;
    }
}
