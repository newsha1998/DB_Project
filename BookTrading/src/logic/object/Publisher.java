package logic.object;

import java.util.Vector;

public class Publisher {
    int id;
    String name;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Vector<Vector<String>> getRows(Vector<Publisher> vec) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        for (Publisher a:vec) {
            Vector<String> b = new Vector<String>();
            b.add(String.valueOf(a.id));
            b.add(a.name);
            ret.add(b);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector<String> ret = new Vector<String>();
        ret.add("Registration Number");
        ret.add("Name");
        return ret;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
