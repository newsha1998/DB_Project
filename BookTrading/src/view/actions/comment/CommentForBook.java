package view.actions.comment;

import logic.Portal.Portal;
import logic.object.Book;
import logic.object.Comment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForBook extends CommentPage {
    int id;

    public CommentForBook(Portal portal) throws HeadlessException {
        super(portal);
        make();
    }

    public CommentForBook(Portal portal, int id) throws HeadlessException {
        super(portal);
        this.id = id;
        username.setText(String.valueOf(id));
        username.setEditable(false);
        make();
    }

    private void make() {
        usernameLabel.setText("Book ID:");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comment comment = new Comment();
                comment.setSenderId(portal.getId());
                comment.setrId(Integer.parseInt(username.getText()));
                comment.setSub(subject.getText());
                comment.setText(text.getText());
                comment.setScore(Double.parseDouble(String.valueOf(score.getValue())));
                portal.insertCommentForBook(comment);
                setVisible(false);
            }
        });
        setVisible(true);
    }
}
