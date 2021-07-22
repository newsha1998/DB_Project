package run;

import logic.Portal.UserPortal;
import logic.sql_instruction.SQLInstruction;
import view.actions.LoginPage;

public class RunAsUser {
    public static void main(String[] args) {
        SQLInstruction instruction = new SQLInstruction();
        UserPortal portal = new UserPortal(instruction);
        LoginPage loginPage = new LoginPage(portal);
    }
}
