package logic.object;

public class Complaint {
    int id, plaintiffId, rId, supportId;
    String sub, text, doc, result;
    String date, time;
    boolean status;

    public Complaint() {
    }

    public int getPlaintiffId() {
        return plaintiffId;
    }

    public void setPlaintiffId(int plaintiffId) {
        this.plaintiffId = plaintiffId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupportId() {
        return supportId;
    }

    public void setSupportId(int supportId) {
        this.supportId = supportId;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
