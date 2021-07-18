package Logic.Portals;


import Logic.Instructions;

import java.sql.SQLException;

public class MemberPortal extends Portal{

    public MemberPortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) {
        try {
            acc = instructions.loginAsUser(id, pass);
            if (acc)
                name = instructions.getUserName(id);
                ID = id;
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
