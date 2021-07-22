package Logic.Portals;

import Logic.Instructions;

import java.sql.SQLException;

public class EmployeePortal extends Portal {
    public EmployeePortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            acc = instructions.loginAsEmployee(id, pass);
            if (acc)
                name = instructions.getEmployeeName(id);
            ID = id;
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
