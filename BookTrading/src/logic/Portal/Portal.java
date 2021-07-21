package logic.Portal;

import logic.sql_instruction.SQLInstruction;

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
}
