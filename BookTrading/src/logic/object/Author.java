package logic.object;

import java.util.Vector;

public class Author {
    int id;
    String name, surname;

    public Author(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Author() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static Vector<Vector<String>> getRows(Vector<Author> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Author a:vec) {
            Vector<String> b = new Vector<String>();
            b.add(String.valueOf(a.id));
            b.add(a.name);
            b.add(a.surname);
            ret.add(b);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector<String> ret = new Vector<String>();
        ret.add("ID");
        ret.add("Name");
        ret.add("Surname");
        return ret;
    }
}
