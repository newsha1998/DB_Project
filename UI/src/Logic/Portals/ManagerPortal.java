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
            acc = instructions.loginAsManager(id, pass);
            if (acc)
                name = instructions.getManagerName(id);
            ID = id;
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public int registerEmployee(String first, String sur, String pass) {
        try {
            return instructions.AddEmployeeAccount(first, sur, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
