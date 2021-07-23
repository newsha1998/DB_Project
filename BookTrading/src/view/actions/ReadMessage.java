package view.actions;

import logic.Portal.Portal;
import view.basic.Panel;

import javax.swing.*;
import java.awt.*;

public class ReadMessage extends Panel {
    JButton message;
    JTextArea reply, Text;
    JTextField Username, Subject;

    public ReadMessage(Portal portal) throws HeadlessException {
        super(portal);

        Label UsernameLabel = new Label("Username:");
        add(UsernameLabel);
        UsernameLabel.setFont(font);
        UsernameLabel.setBounds(20, 40, 120, 30);

        Username = new JTextField();
        add(Username);
        Username.setFont(font);
        Username.setEditable(false);
        Username.setBounds(150, 40, 200, 30);

        Label subjectLabel = new Label("Subject:");
        add(subjectLabel);
        subjectLabel.setFont(font);
        subjectLabel.setBounds(20, 80, 120, 30);

        Subject = new JTextField();
        add(Subject);
        Subject.setFont(font);
        Subject.setEditable(false);
        Subject.setBounds(150, 80, 200, 30);

        Label textLabel = new Label("Text:");
        add(textLabel);
        textLabel.setFont(font);
        textLabel.setBounds(20, 140, 120, 30);

        Text = new JTextArea();
        Text.setLineWrap(true);
        Text.setWrapStyleWord(true);
        Text.setEditable(false);
        JScrollPane sp = new JScrollPane(Text);
        add(sp);
        Text.setFont(font);
        sp.setBounds(150, 140, 450, 150);

        Label replyLabel = new Label("Reply:");
        add(replyLabel);
        replyLabel.setFont(font);
        replyLabel.setBounds(20, 320, 120, 30);

        reply = new JTextArea();
        reply.setLineWrap(true);
        reply.setWrapStyleWord(true);
        JScrollPane sp2 = new JScrollPane(reply);
        add(sp2);
        reply.setFont(font);
        sp2.setBounds(150, 320, 450, 200);

        message = new JButton("Send Reply");
        add(message);
        message.setFont(font);
        message.setBounds(350, 570, 200, 50);


    }


    public JButton getMessage() {
        return message;
    }

    public String getReplyText(){
        return reply.getText();
    }

    public JTextArea getText() {
        return Text;
    }


    public JTextField getUsername() {
        return Username;
    }


    public JTextField getSubject() {
        return Subject;
    }

    public void setReplyText(String reply) {
        this.reply.setText(reply);
    }
}
