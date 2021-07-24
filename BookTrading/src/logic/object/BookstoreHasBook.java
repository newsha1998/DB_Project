package logic.object;

import logic.Portal.Portal;

import java.util.Vector;

public class BookstoreHasBook {
    int bookstoreId, bookId, number;
    double price;

    public BookstoreHasBook() {
    }

    public BookstoreHasBook(int bookstoreId, int bookId, int number, double price) {
        this.bookstoreId = bookstoreId;
        this.bookId = bookId;
        this.number = number;
        this.price = price;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String >();
        ret.add("Book ID");
        ret.add("Book Name");
        ret.add("Book Number");
        ret.add("Price");
        return ret;
    }

    public static Vector <Vector<String>> getRows(Portal portal, Vector<BookstoreHasBook> BookstoreHasBooks) {
        Vector <Vector<String>> ret = new Vector<Vector<String>>();
        for (BookstoreHasBook b : BookstoreHasBooks) {
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(b.getBookId()));
            a.add(portal.getBookById(b.getBookId()).getName());
            a.add(String.valueOf(b.getNumber()));
            a.add(String.valueOf(b.getPrice()));
            ret.add(a);
        }
        return ret;
    }

    public int getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(int bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
