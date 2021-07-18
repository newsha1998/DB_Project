package Logic;

import java.sql.SQLException;

public class ManagerPortal extends Portal {
    public ManagerPortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            return acc = instructions.loginAsManager(id, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
