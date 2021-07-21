package logic.object;

public class Advertisement {
    int Id, BookId, UserId;
    String Title, Description;
    double ProposedPrice;

    public Advertisement() {
    }

    public Advertisement(int Id, int BookId, int UserId) {
        this.Id = Id;
        this.UserId = UserId;
        this.BookId = BookId;
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
}