package logic.object;

import java.util.Vector;

public class Message {
    int Id, receiverId, senderId;
    String subject, text, Date, Time, senderUsername, receiverUsername;

    public Message(){
    }

    public Message(int receiver, int sender){
        this.receiverId = receiver;
        this.senderId = sender;
    }


    public static Vector<Vector<String>> getRows(Vector<Message> vec) {
        Vector <Vector<String>> ret = new Vector<Vector<String>>();
        for (Message m : vec){
            Vector<String> a = new Vector<String>();
            a.add(String.valueOf(m.getId()));
            a.add(m.getSenderUsername());
            a.add(m.getSubject());
            a.add(m.getDate());
            a.add(m.getTime());

            ret.add(a);
        }
        return ret;
    }

    public static Vector<String> getColumns() {
        Vector <String> ret = new Vector<String>();
        ret.add("Message Id");
        ret.add("Sender Username");
        ret.add("Subject");
        ret.add("Date");
        ret.add("Time");

        return ret;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }
}
