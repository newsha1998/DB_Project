package logic.object;

import java.util.Vector;

public class Bookstore {
    int id;
    String username, name, email, city, region, street, alley, building, website;
    double score;
    Vector <String> phone = new Vector<String>();
    Vector <BookstoreHasBook> bookstoreHasBooks = new Vector<BookstoreHasBook>();

    public void addBook(BookstoreHasBook b) {
        bookstoreHasBooks.add(b);
    }

    public String getPhone() {
        String ret = "";
        for (String i:phone) {
            if (!ret.equals(""))
                ret = ret + ", " + i;
            else
                ret = ret + i;
        }
        if (ret.equals("")) {
            ret = "NA";
        }
        return ret;
    }

    public Vector<BookstoreHasBook> getBookstoreHasBooks() {
        return bookstoreHasBooks;
    }

    public void addPhone(String s) {
        phone.add(s);
    }

    public Bookstore() {
    }

    public static Vector<Vector<String>> getRows(Vector<Bookstore> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Bookstore a:vec) {
            Vector<String> b = new Vector<String>();
            b.add(String.valueOf(a.getId()));
            b.add(a.getName());
            b.add(a.getEmail());
            b.add(a.getAdr());
            b.add(a.getWebsite());
            b.add(a.getStringScore());
            ret.add(b);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector<String> ret = new Vector<String>();
        ret.add("ID");
        ret.add("Name");
        ret.add("Email");
        ret.add("Address");
        ret.add("Website");
        ret.add("Score");
        return ret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null)  email = "NA";
        this.email = email;
    }

    public void setCity(String city) {
        if(city == null)    city = "";
        this.city = city;
    }

    public void setRegion(String region) {
        if(region == null)    region = "";
        this.region = region;
    }

    public void setStreet(String street) {
        if(street == null)    street = "";
        this.street = street;
    }

    public void setAlley(String alley) {
        if(alley == null)    alley = "";
        this.alley = alley;
    }

    public void setBuilding(String building) {
        if(building == null)    building = "";
        this.building = building;
    }

    public String getAdr() {
        return city + ", " + region + ", " + street + ", " + alley + ", " + building;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (website == null) website = "NA";
        this.website = website;
    }

    public String getStringScore() {
        if (score < 0)
            return "NA";
        return String.format("%.2f",score);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
