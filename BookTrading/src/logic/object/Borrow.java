package logic.object;

import java.util.Vector;

public class Borrow {

    int id, BorrowerId, LenderId, BookId, confirmation;
    String BorrowerUsername, LenderUsername, StartDate, DeadlineDate, DeliveryAddress, Description, BookName;
    double DailyDelayPenalty, GuaranteePrice, Price;



    public Borrow(){

    }

    public Borrow(int Id) {
        this.id = Id;
    }

    public static Vector<Vector<String>> getRows(Vector<Borrow> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Borrow borrow : vec) {
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(borrow.getId()));
            a.add(borrow.getBorrowerUsername());
            a.add(String.valueOf(borrow.getBookId()));
            a.add(borrow.getBookName());
            a.add(borrow.getStartDate());
            a.add(borrow.getDeadlineDate());
            a.add(borrow.getDeliveryAddress());
            a.add(borrow.getDescription());


            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String>();
        ret.add("Borrow Id");
        ret.add("Username");
        ret.add("Book Id");
        ret.add("Book Name");
        ret.add("Start Date");
        ret.add("Deadline Date");
        ret.add("Delivery Address");
        ret.add("Description");

        return ret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        BorrowerId = borrowerId;
    }

    public int getLenderId() {
        return LenderId;
    }

    public void setLenderId(int lenderId) {
        LenderId = lenderId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getLenderUsername() {
        return LenderUsername;
    }

    public void setLenderUsername(String lenderUsername) {
        LenderUsername = lenderUsername;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getDeadlineDate() {
        return DeadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        DeadlineDate = deadlineDate;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getDailyDelayPenalty() {
        return DailyDelayPenalty;
    }

    public void setDailyDelayPenalty(double dailyDelayPenalty) {
        DailyDelayPenalty = dailyDelayPenalty;
    }

    public double getGuaranteePrice() {
        return GuaranteePrice;
    }

    public void setGuaranteePrice(double guaranteePrice) {
        GuaranteePrice = guaranteePrice;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getBorrowerUsername() {
        return BorrowerUsername;
    }

    public void setBorrowerUsername(String borrowerUsername) {
        BorrowerUsername = borrowerUsername;
    }

    public void setBookName(String bookName) {
        this.BookName = bookName;
    }

    public String getBookName() {
        return BookName;
    }

    public int getConfirmation() {
        return confirmation;
    }
}
