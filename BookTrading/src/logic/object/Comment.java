package logic.object;

public class Comment {
    int id, senderId, rId;
    double score;
    String sub, text, rType;

    public Comment() {
    }

    public Comment(int senderId, int rId, double score, String sub, String text) {
        this.senderId = senderId;
        this.rId = rId;
        this.score = score;
        this.sub = sub;
        this.text = text;
    }

    public Comment(int senderId, int rId, double score, String sub, String text, String rType) {
        this.senderId = senderId;
        this.rId = rId;
        this.score = score;
        this.sub = sub;
        this.text = text;
        this.rType = rType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }
}
