package logic.object;

import java.util.Vector;

public class UserHasBook {
    int bookId, num;
    String bookName, status;

    public UserHasBook(int bookId, String bookName, int num, String status) {
        this.bookId = bookId;
        this.num = num;
        this.bookName = bookName;
        this.status = status;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String >();
        ret.add("Book ID");
        ret.add("Book Name");
        ret.add("Book Number");
        ret.add("Status");
        return ret;
    }

    public static Vector <Vector<String>> Convert(Vector<UserHasBook> userHasBooks) {
        Vector <Vector<String>> ret = new Vector<Vector<String>>();
        for (UserHasBook b : userHasBooks) {
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(b.getBookId()));
            a.add(b.getBookName());
            a.add(String.valueOf(b.getNum()));
            a.add(b.getStatus());
            ret.add(a);
        }
        return ret;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public int getNum() {
        return num;
    }

    public String getBookName() {
        return bookName;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
