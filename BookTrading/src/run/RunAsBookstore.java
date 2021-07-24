package run;

import logic.Portal.BookstorePortal;
import logic.Portal.ManagerPortal;
import logic.object.Bookstore;
import logic.sql_instruction.SQLInstruction;
import view.actions.login.LoginPage;

public class RunAsBookstore {
    public static void main(String[] args) {
        SQLInstruction instruction = new SQLInstruction();
        BookstorePortal portal = new BookstorePortal(instruction);
        LoginPage loginPage = new LoginPage(portal);
    }
}
