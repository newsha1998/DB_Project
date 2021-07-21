package logic.Portal;

import logic.sql_instruction.SQLInstruction;

public abstract class Portal {
    SQLInstruction sqlInstruction;

    public Portal(SQLInstruction sqlInstruction) {
        this.sqlInstruction = sqlInstruction;
    }
}
