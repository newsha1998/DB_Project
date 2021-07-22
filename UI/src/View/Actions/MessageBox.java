package View.Actions;

import Logic.Portals.MemberPortal;
import Logic.Portals.Portal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBox extends JFrame {
    static int x = 400, y = 450;
    MemberPortal portal;

    public MessageBox(MemberPortal port){
        portal = port;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);
        Label re = new Label("Receiver ID");
        re.setBounds(10, 10, 100, 30);
        add(re);
        TextField reid = new TextField();
        reid.setBounds(110, 10, 100, 30);
        add(reid);
        Label sub = new Label("Subject");
        sub.setBounds(10, 60, 100, 30);
        add(sub);
        TextField subject = new TextField();
        subject.setBounds(110, 60, 100, 30);
        add(subject);

        JTextArea text = new JTextArea();
        text.setBounds(20, 100, 350, 230);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setAutoscrolls(true);
        add(text);

        JButton b = new JButton("Send");
        b.setBounds(150, 350, 100, 50);
        add(b);

        setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                port.sendMessage(Integer.parseInt(reid.getText()), subject.getText(), text.getText());
                setVisible(false);
            }
        });
    }
}
