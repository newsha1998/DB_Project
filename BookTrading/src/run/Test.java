package run;

import logic.Portal.UserPortal;
import logic.sql_instruction.SQLInstruction;
import view.profile.UserProfile;

public class Test {
    public static void main(String[] args) {

        UserProfile profile = new UserProfile(new UserPortal(new SQLInstruction()), 1);
    }
}
