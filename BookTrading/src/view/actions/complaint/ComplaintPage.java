package view.actions.complaint;

import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ComplaintPage extends MiniPage {
    Label usernameLabel, subjectLabel, textLabel, docsLabel;
    JTextField username, subject;
    JTextArea text, doc;
    JScrollPane sp, sp2;
    JButton submit;

    public ComplaintPage(Portal portal) throws HeadlessException {
        super(portal);
        font = new Font("SansSerif", Font.PLAIN, 15);
        setTitle("Complaint");

        usernameLabel = new Label();
        usernameLabel.setFont(font);
        add(usernameLabel);
        usernameLabel.setBounds(20, 20, 110, 30);
        username = new JTextField();
        username.setFont(font);
        add(username);
        username.setBounds(130, 20, 100, 30);

        subjectLabel = new Label("Subject:");
        subjectLabel.setFont(font);
        add(subjectLabel);
        subjectLabel.setBounds(20, 60, 85, 30);
        subject = new JTextField();
        subject.setFont(font);
        add(subject);
        subject.setBounds(130, 60, 100, 30);

        textLabel = new Label("Text:");
        textLabel.setFont(font);
        add(textLabel);
        textLabel.setBounds(20, 180, 50, 30);

        text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        sp = new JScrollPane(text);
        add(sp);
        text.setFont(font);
        sp.setBounds(70, 180, 315, 110);

        docsLabel = new Label("Documents:");
        docsLabel.setFont(font);
        add(docsLabel);
        docsLabel.setBounds(20, 100, 100, 30);

        doc = new JTextArea();
        doc.setLineWrap(true);
        doc.setWrapStyleWord(true);
        sp2 = new JScrollPane(doc);
        add(sp2);
        doc.setFont(font);
        sp2.setBounds(120, 100, 265, 70);

        font = new Font("SansSerif", Font.PLAIN, 25);
        submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.setBounds(230, 300, 140, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setVisible(true);
    }
}
