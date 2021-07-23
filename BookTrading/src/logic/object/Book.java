package logic.object;

import logic.Portal.Portal;

import java.util.Vector;

public class Book {
    int id, pubid;
    String name, genre, lang, releaseDate, material, des, sum, cat, size, series;
    double score, price;
    Vector <Integer> authors, interpreters;

    public Book() {
    }

    public Book(int pubid, String series, String name, String genre, String lang, String releaseDate, String material, String des, String sum, String cat, String size,  Vector<Integer> authors, Vector<Integer> interpreters) {
        this.pubid = pubid;
        this.series = series;
        this.name = name;
        this.genre = genre;
        this.lang = lang;
        this.releaseDate = releaseDate;
        this.material = material;
        this.des = des;
        this.sum = sum;
        this.cat = cat;
        this.size = size;
        this.authors = authors;
        this.interpreters = interpreters;
    }

    public Book(String name) {
        this.name = name;
    }

    public static Vector<Vector<String>> getRows(Portal portal, Vector<Book> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Book b:vec) {
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(b.getId()));
            a.add(b.getName());
            if (b.getPubid() != 0)
                a.add(portal.getPublisherName(b.getPubid()));
            else
                a.add("NA");
            String authors = "";
            for (int i:b.getAuthors()) {
                authors = authors + portal.getAuthorName(i) + ", ";
            }
            if (authors.equals(""))
                authors = "NA";
            a.add(authors);
            String inter = "";
            for (int i:b.getInterpreters()) {
                inter = inter + portal.getInterpreterName(i) + ", ";
            }
            if (inter.equals(""))
                inter = "NA";
            a.add(inter);
            a.add(b.getGenre());
            if (b.getScore() >= 0)
                a.add(String.valueOf(b.getScore()));
            else
                a.add("NA");
            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector<String> ret = new Vector<String>();
        ret.add("ID");
        ret.add("Name");
        ret.add("Publisher");
        ret.add("Authors");
        ret.add("Interpreters");
        ret.add("Genre");
        ret.add("Score");
        return ret;
    }

    public static Vector<Vector<String>> getMiniRows(Portal portal, Vector<Book> books) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Book b:books) {
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(b.getId()));
            a.add(b.getName());
            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getMiniColumns() {
        Vector<String> ret = new Vector<String>();
        ret.add("ID");
        ret.add("Name");
        return ret;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPubid(int pubid) {
        this.pubid = pubid;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPubid() {
        return pubid;
    }

    public String getSeries() {
        return series;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getLang() {
        return lang;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMaterial() {
        return material;
    }

    public String getDes() {
        return des;
    }

    public String getSum() {
        return sum;
    }

    public String getCat() {
        return cat;
    }

    public String getSize() {
        return size;
    }

    public double getScore() {
        return score;
    }

    public double getPrice() {
        return price;
    }

    public Vector<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(Vector<Integer> authors) {
        this.authors = authors;
    }

    public Vector<Integer> getInterpreters() {
        return interpreters;
    }

    public void setInterpreters(Vector<Integer> interpreters) {
        this.interpreters = interpreters;
    }
}
