package Logic.Portals;


import Logic.Instructions;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

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

    public void sendMessage(int reid, String sub, String txt) {
        try {
            instructions.AddMessage(ID, reid, sub, txt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getMessagesId() {
        try {
            return instructions.getMessagesId(ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSubjectMessageDetails(int mid) {
        try {
            return instructions.getSubjectMessageDetails(mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getseidMessageDetails(int mid) {
        try {
            return instructions.getsenderIdMessageDetails(mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String gettextMessageDetails(int mid) {
        try {
            return instructions.getTextMessageDetails(mid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int borrowreq(int LenderId, int BookId, double Price,
                          String StartDate, String  DeadlineDate, double DailyDelayPenalty,
                          double GuaranteePrice, String DeliveryAddress, String Description) {
        try {
            return instructions.AddBorrowReq(ID, LenderId, BookId, Price, StartDate, DeadlineDate, DailyDelayPenalty,
                    GuaranteePrice, DeliveryAddress, Description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
