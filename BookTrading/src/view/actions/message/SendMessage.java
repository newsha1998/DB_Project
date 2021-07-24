package view.actions.message;

import logic.Portal.UserPortal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMessage extends MiniPage{
    JTextField username;

    public void SetUsername(String username){
        this.username.setText(username);
        this.username.setEditable(false);
    }

    public SendMessage(UserPortal portal) throws HeadlessException {
        super(portal);
        font = new Font("SansSerif", Font.PLAIN, 20);

        Label UsernameLabel = new Label("Username:");
        add(UsernameLabel);
        UsernameLabel.setFont(font);
        UsernameLabel.setBounds(20, 20, 120, 30);

        username = new JTextField();
        add(username);
        username.setFont(font);
        username.setBounds(150, 20, 150, 30);

        Label subjectLabel = new Label("Subject:");
        add(subjectLabel);
        subjectLabel.setFont(font);
        subjectLabel.setBounds(20, 60, 120, 30);

        JTextField subject = new JTextField();
        add(subject);
        subject.setFont(font);
        subject.setBounds(150, 60, 150, 30);

        Label textLabel = new Label("Text:");
        add(textLabel);
        textLabel.setFont(font);
        textLabel.setBounds(20, 100, 100, 30);

        JTextArea text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(text);
        add(sp);
        text.setFont(font);
        sp.setBounds(20, 140, 360, 150);

        JButton send = new JButton("Send");
        send.setFont(font);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    portal.SendMessage(portal.getId(), username.getText(), subject.getText(), text.getText());
                    JOptionPane.showMessageDialog(getParent(),
                            "Message has sent successfully",
                            "",
                            JOptionPane.PLAIN_MESSAGE);
                    SendMessage.this.setVisible(false);
                }
            }
        });
        add(send);
        send.setBounds(150, 300, 100, 50);
    }

}
