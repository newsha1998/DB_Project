package Logic;


import java.sql.SQLException;

public class MemberPortal extends Portal{

    public MemberPortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) {
        try {
            return acc = instructions.loginAsUser(id, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
