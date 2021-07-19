package View;

import Logic.Portals.MemberPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReadMessages extends JFrame {
    MemberPortal portal;
    static int x = 500, y = 450;

    public ReadMessages(MemberPortal portal) throws HeadlessException {
        this.portal = portal;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);
        Label re = new Label("Sender ID");
        re.setBounds(10, 10, 100, 30);
        add(re);
        TextField seid = new TextField();
        seid.setBounds(110, 10, 100, 30);
        add(seid);
        seid.setEditable(false);
        Label sub = new Label("Subject");
        sub.setBounds(10, 60, 100, 30);
        add(sub);
        TextField subject = new TextField();
        subject.setBounds(110, 60, 100, 30);
        subject.setEditable(false);
        add(subject);

        JTextArea text = new JTextArea();
        text.setBounds(20, 100, 350, 230);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setAutoscrolls(true);
        text.setEditable(false);
        add(text);

        JComboBox comboBox = new JComboBox();
        List <Integer> list = portal.getMessagesId();
        for (Integer element : list) {
            comboBox.addItem(element.toString());
        }
        add(comboBox);
        comboBox.setBounds(400, 50, 70, 40);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mid=Integer.parseInt(comboBox.getSelectedItem().toString());
                subject.setText(portal.getSubjectMessageDetails(mid));
                seid.setText(String.valueOf(portal.getseidMessageDetails(mid)));
                text.setText(portal.gettextMessageDetails(mid));
            }
        });
        setVisible(true);
    }
}
