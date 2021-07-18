package Logic.Portals;

import Logic.Instructions;

import java.sql.SQLException;

public class ManagerPortal extends Portal {
    public ManagerPortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            acc = instructions.loginAsUser(id, pass);
            if (acc)
                name = instructions.getManagerName(id);
            ID = id;
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
