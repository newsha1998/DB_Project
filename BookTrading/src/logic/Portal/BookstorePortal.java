package logic.Portal;

import logic.sql_instruction.SQLInstruction;

public class BookstorePortal extends Portal {
    public BookstorePortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    @Override
    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsBookstore(username, password);
        if (ret == -1) {
            return access = false;
        }
        this.id = ret;
        return access = true;
    }

    @Override
    public boolean changePassword(String oldPass, String newPass) {
        return sqlInstruction.getUpdate().updateBookstorePassword(getId(), oldPass, newPass);
    }

    public void addPhone(String phone) {
        sqlInstruction.getInsert().addPhoneForBookstore(getId(), phone);
    }

    public void removePhone(String phone) {
        sqlInstruction.getUpdate().removePhoneForBookstore(getId(), phone);
    }
}
