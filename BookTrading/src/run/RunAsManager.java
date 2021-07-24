package run;

import logic.Portal.ManagerPortal;
import logic.Portal.UserPortal;
import logic.sql_instruction.SQLInstruction;
import view.actions.login.LoginPage;

public class RunAsManager {
    public static void main(String[] args) {
        SQLInstruction instruction = new SQLInstruction();
        ManagerPortal portal = new ManagerPortal(instruction);
        LoginPage loginPage = new LoginPage(portal);
    }
}
