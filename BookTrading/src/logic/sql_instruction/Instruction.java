package logic.sql_instruction;

import java.sql.Connection;

public abstract class Instruction {
    Connection connection;

    public Instruction(Connection connection) {
        this.connection = connection;
    }
}
