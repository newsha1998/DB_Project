package Logic.Portals;

import Logic.Instructions;

import java.sql.SQLException;

public class BookstorePortal extends Portal {
    public BookstorePortal(Instructions ins) {
        super(ins);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean login(int id, String pass) throws SQLException {
        try {
            acc = instructions.loginAsBookstore(id, pass);
            if (acc)
                name = instructions.getBookstoreName(id);
            ID = id;
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
