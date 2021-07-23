package view.actions.comment;

import logic.Portal.Portal;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;

public abstract class CommentPage extends MiniPage {
    protected JButton submit;
    protected JScrollPane sp;
    protected JTextArea text;
    protected Label textLabel, subjectLabel, ScoreLabel, usernameLabel;
    protected JTextField subject, username;
    protected JSpinner score;

    public CommentPage(Portal portal) throws HeadlessException {
        super(portal);

        usernameLabel = new Label();
        usernameLabel.setFont(font);
        add(usernameLabel);
        usernameLabel.setBounds(20, 20, 120, 50);
        username = new JTextField();
        username.setFont(font);
        add(username);
        username.setBounds(140, 20, 150, 50);

        ScoreLabel = new Label("Score:");
        ScoreLabel.setFont(font);
        add(ScoreLabel);
        ScoreLabel.setBounds(20, 80, 70, 50);
        SpinnerNumberModel model =
                new SpinnerNumberModel(10, //initial value
                        0, //min
                        10, //max
                        1);
        score = new JSpinner(model);
        add(score);
        score.setFont(font);
        score.setAutoscrolls(true);
        score.setBounds(90, 80, 50, 50);
        setVisible(true);

        subjectLabel = new Label("Subject:");
        subjectLabel.setFont(font);
        add(subjectLabel);
        subjectLabel.setBounds(150, 80, 85, 50);
        subject = new JTextField();
        subject.setFont(font);
        add(subject);
        subject.setBounds(235, 80, 150, 50);

        textLabel = new Label("Text:");
        textLabel.setFont(font);
        add(textLabel);
        textLabel.setBounds(20, 140, 50, 50);

        text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        sp = new JScrollPane(text);
        add(sp);
        text.setFont(font);
        sp.setBounds(70, 140, 315, 150);

        submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.setBounds(230, 300, 140, 50);
        setVisible(true);
    }
}
