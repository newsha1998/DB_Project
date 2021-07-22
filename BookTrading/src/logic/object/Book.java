package logic.object;

import java.util.Vector;

public class Book {
    int id, pubid, series;
    String name, genre, lang, releaseDate, material, des, sum, cat, size;
    double score, price;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPubid(int pubid) {
        this.pubid = pubid;
    }

    public void setSeries(int series) {
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

    public int getSeries() {
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
}
