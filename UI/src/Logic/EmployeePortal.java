package Logic;

import java.sql.SQLException;

public class EmployeePortal extends Portal {
    public EmployeePortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            return acc = instructions.loginAsEmployee(id, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
