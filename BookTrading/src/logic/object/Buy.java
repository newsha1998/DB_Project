package logic.object;


import java.util.Vector;

public class Buy {

    int id, buyerId, sellerId, BookId;
    String Date, Description, BookName, sellerUserName, buyerUsername, deliveryAddress;
    boolean success;
    double price;

    public Buy() {

    }

    public static Vector<Vector<String>> getRows(Vector<Buy> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Buy buy : vec) {
            Vector<String> a = new Vector<String>();
            a.add(buy.getBuyerUsername());
            a.add(String.valueOf(buy.getBookId()));
            a.add(buy.getBookName());
            a.add(buy.getDate());
            a.add(buy.getDeliveryAddress());
            a.add(String.valueOf(buy.getPrice()));
            a.add(buy.getDescription());


            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String>();
        ret.add("Buyer Username");;
        ret.add("Book Id");
        ret.add("Book Name");
        ret.add("Date");
        ret.add("Delivery Address");
        ret.add("Price");
        ret.add("Description");

        return ret;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return Date;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isSuccess() {
        return success;
    }

    public double getPrice() {
        return price;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public void setSellerUserName(String sellerUserName) {
        this.sellerUserName = sellerUserName;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public void setBuyerUsername(String buyerUsername) {
        this.buyerUsername = buyerUsername;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
