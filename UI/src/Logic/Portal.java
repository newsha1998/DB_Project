package Logic;

import java.sql.SQLException;

public abstract class Portal {
    boolean acc;
    Instructions instructions;

    public Portal(Instructions ins) {
        this.acc = false;
        instructions = ins;
    }

    public abstract boolean login(int id, String pass) throws SQLException;
}
