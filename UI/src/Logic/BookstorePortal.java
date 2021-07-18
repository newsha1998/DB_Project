package Logic;

import java.sql.SQLException;

public class BookstorePortal extends Portal {
    public BookstorePortal(Instructions ins) {
        super(ins);
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            return acc = instructions.loginAsBookstore(id, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
