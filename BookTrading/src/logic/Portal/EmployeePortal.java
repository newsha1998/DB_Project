package logic.Portal;

import logic.object.Employee;
import logic.object.Manager;
import logic.sql_instruction.SQLInstruction;

public class EmployeePortal extends Portal {
    public EmployeePortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    @Override
    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsEmployee(username, password);
        if (ret == -1) {
            return access = false;
        }
        this.id = ret;
        return access = true;
    }

    @Override
    public boolean changePassword(String oldPass, String newPass) {
        return sqlInstruction.getUpdate().updateEmployeePassword(getId(), oldPass, newPass);
    }

    public Employee getEmployee() {
        return sqlInstruction.getExtractor().extractEmployeeById(getId());
    }

    public void updateEmployee(Employee employee) {
        sqlInstruction.getUpdate().updateEmployee(employee);
    }
}
