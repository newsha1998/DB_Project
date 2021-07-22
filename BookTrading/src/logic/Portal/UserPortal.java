package logic.Portal;

import logic.object.Book;
import logic.object.User;
import logic.object.UserHasBook;
import logic.sql_instruction.SQLInstruction;

import java.util.Vector;

public class UserPortal extends Portal {
    public UserPortal(SQLInstruction sqlInstruction) {
        super(sqlInstruction);
    }

    @Override
    public boolean login(String username, String password) {
        int ret = sqlInstruction.getLogin().loginAsUser(username, password);
        if (ret == -1) {
            return access = false;
        }
        this.id = ret;
        return access = true;
    }

    public int registerUser(String username, String password, String name, String surname) {
        return sqlInstruction.getRegister().registerUser(username, password, name, surname);
    }

    public boolean existUser(String username) {
        return sqlInstruction.getExists().existUser(username);
    }

    public void addBook(int bookId, int num) {
        sqlInstruction.getUpdate().addBookForUser(id, bookId, num);
    }

    public void romoveBook(int bookId, int num) {
        sqlInstruction.getUpdate().addBookFromUser(id, bookId, num);
    }

    public void changeBookStatus(int bookId, String status) {
        sqlInstruction.getUpdate().changeBookStatus(id, bookId, status);
    }

    public void UpdateUser(String type, String username, String input){
        if (type.equals("name"))
            sqlInstruction.getUpdate().UpdateUserFirstName(username, input);

        if (type.equals("surname"))
            sqlInstruction.getUpdate().UpdateUserSurname(username, input);

        if (type.equals("city"))
            sqlInstruction.getUpdate().UpdateUserCity(username, input);

        if (type.equals("region"))
            sqlInstruction.getUpdate().UpdateUserRegion(username, input);

        if (type.equals("alley"))
            sqlInstruction.getUpdate().UpdateUserAlley(username, input);

        if (type.equals("HouseNo"))
            sqlInstruction.getUpdate().UpdateUserHouseNo(username, input);

        if (type.equals("street"))
            sqlInstruction.getUpdate().UpdateUserStreet(username, input);

        if (type.equals("email"))
            sqlInstruction.getUpdate().UpdateUserEmail(username, input);

        if (type.equals("phone"))
            sqlInstruction.getUpdate().UpdateUserPhone(username, input);
    }

}
