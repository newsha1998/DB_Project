package Logic.Portals;

import Logic.Instructions;

import java.sql.SQLException;

public abstract class Portal {
    boolean acc;
    Instructions instructions;
    String name;
    int ID;

    public Portal(Instructions ins) {
        this.acc = false;
        instructions = ins;
    }

    public String getName() {
        return name;
    }

    public abstract boolean login(int id, String pass) throws SQLException;
}
