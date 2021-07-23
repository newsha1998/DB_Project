package logic.object;

import java.util.Vector;

public class Advertisement {
    int Id, BookId, UserId;
    String Title, Description, BookName, username;
    double ProposedPrice;


    public Advertisement() {
    }

    public Advertisement(int Id, int BookId, int UserId) {
        this.Id = Id;
        this.UserId = UserId;
        this.BookId = BookId;
    }

    public static Vector<Vector<String>> getRows(Vector<Advertisement> vec) {
        Vector <Vector<String>> ret = new Vector<Vector<String>>();
        for (Advertisement ad : vec){
            Vector<String> a = new Vector<String>();
            a.add(ad.getUsername());
            a.add(ad.getTitle());
            a.add(ad.getBookName());
            a.add(String.valueOf(ad.getProposedPrice()));
            a.add(ad.getDescription());

            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String>();
        ret.add("Username");
        ret.add("Title");
        ret.add("Book Name");
        ret.add("Proposed Price");
        ret.add("Description");

        return ret;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setProposedPrice(double proposedPrice) {
        ProposedPrice = proposedPrice;
    }

    public int getId() {
        return Id;
    }

    public int getBookId() {
        return BookId;
    }

    public int getUserId() {
        return UserId;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public double getProposedPrice() {
        return ProposedPrice;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
