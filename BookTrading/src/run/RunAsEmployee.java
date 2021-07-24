package run;

import logic.Portal.EmployeePortal;
import logic.Portal.ManagerPortal;
import logic.object.Employee;
import logic.sql_instruction.SQLInstruction;
import view.actions.login.LoginPage;

public class RunAsEmployee {
    public static void main(String[] args) {
        SQLInstruction instruction = new SQLInstruction();
        EmployeePortal portal = new EmployeePortal(instruction);
        LoginPage loginPage = new LoginPage(portal);
    }
}
