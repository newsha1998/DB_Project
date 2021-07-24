package view.list;

import logic.Portal.Portal;
import logic.object.Book;
import logic.object.Bookstore;
import view.actions.comment.CommentForBook;
import view.actions.comment.CommentForBookstore;
import view.basic.MyTableModel;
import view.basic.Panel;
import view.profile.BookstoreProfile;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookstoreList extends Panel {
    JButton comment, profile;
    ListSelectionModel sm;
    Vector<Vector<String >> data;
    JScrollPane scrollPane;
    JTable table;

    public BookstoreList(Portal portal) {
        super(portal);

        Label userListLabel = new Label("Bookstore's List");
        userListLabel.setBounds(20, 40, 150, 50);
        userListLabel.setFont(font);
        add(userListLabel);
        Vector <Bookstore> vec = portal.getBookstoresTable();
        data = Bookstore.getRows(vec);
        table = new JTable(new MyTableModel(data , Bookstore.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        sm = table.getSelectionModel();

        profile = new JButton("View Profile");
        add(profile);
        profile.setFont(font);
        profile.setBounds(100, 550, 200, 50);

        comment = new JButton("Comment");
        add(comment);
        comment.setFont(font);
        comment.setBounds(600, 550, 200, 50);
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentForBookstore commentForBook = new CommentForBookstore(portal, getSelected());
            }
        });

        comment.setEnabled(false);
        profile.setEnabled(false);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    comment.setEnabled(false);
                    profile.setEnabled(false);
                } else {
                    comment.setEnabled(true);
                    profile.setEnabled(true);
                }
            }
        });
    }

    public JButton getComment() {
        return comment;
    }

    public JButton getProfile() {
        return profile;
    }

    public int getSelected() {
        return Integer.parseInt(data.elementAt(sm.getMinSelectionIndex()).elementAt(0));
    }
}