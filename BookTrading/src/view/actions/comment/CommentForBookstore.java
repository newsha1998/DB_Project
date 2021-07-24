package view.actions.comment;

import logic.Portal.Portal;
import logic.object.Comment;
import view.profile.BookstoreProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentForBookstore extends CommentPage{
    int id;
    BookstoreProfile profile;

    public CommentForBookstore(Portal portal) throws HeadlessException {
        super(portal);
        make();
    }

    public CommentForBookstore(Portal portal, int id) throws HeadlessException {
        super(portal);
        this.id = id;
        username.setText(String.valueOf(id));
        username.setEditable(false);
        make();
    }

    private void make() {
        usernameLabel.setText("Bookstore ID:");
        usernameLabel.setBounds(20, 20, 160, 50);
        username.setBounds(180, 20, 150, 50);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comment comment = new Comment();
                comment.setSenderId(portal.getId());
                comment.setrId(Integer.parseInt(username.getText()));
                comment.setSub(subject.getText());
                comment.setText(text.getText());
                comment.setScore(Double.parseDouble(String.valueOf(score.getValue())));
                portal.insertCommentForBookstore(comment);
                setVisible(false);
                if(profile != null) {
                    profile.updateScore();
                }
            }
        });
        setVisible(true);
    }

    public CommentForBookstore(Portal portal, int id, BookstoreProfile profile) throws HeadlessException {
        super(portal);
        this.id = id;
        this.profile = profile;
        username.setText(String.valueOf(id));
        username.setEditable(false);
        make();
    }
}
