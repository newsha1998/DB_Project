package view.list;

import logic.Portal.Portal;
import logic.object.Book;
import view.actions.comment.CommentForBook;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookList extends Panel {
    JButton comment, search;
    ListSelectionModel sm;
    Vector<Vector<String >> data;
    JScrollPane scrollPane;
    JTable table;

    public BookList(Portal portal) {
        super(portal);

        Label userListLabel = new Label("User's List");
        userListLabel.setBounds(20, 40, 150, 50);
        userListLabel.setFont(font);
        add(userListLabel);
        Vector <Book> vec = portal.getAllBooks();
        data = Book.getRows(portal, vec);
        table = new JTable(new MyTableModel(data , Book.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        sm = table.getSelectionModel();

        TextField sea = new TextField();
        sea.setFont(font);
        add(sea);
        sea.setBounds(75, 550, 150, 50);

        search = new JButton("Search");
        add(search);
        search.setFont(font);
        search.setBounds(250, 550, 110, 50);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector <Book> vec = portal.getAllSimilarBooks(sea.getText());
                remove(scrollPane);
                data = Book.getRows(portal, vec);
                table = new JTable(new MyTableModel(data , Book.getColumns()));
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                scrollPane = new JScrollPane(table);
                add(scrollPane);
                scrollPane.setBounds(50, 100, 800, 400);
                sm = table.getSelectionModel();
            }
        });

        comment = new JButton("Comment");
        add(comment);
        comment.setFont(font);
        comment.setBounds(600, 550, 200, 50);
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentForBook commentForBook = new CommentForBook(portal, getSelected());
            }
        });

        comment.setEnabled(false);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    comment.setEnabled(false);
                } else {
                    comment.setEnabled(true);
                }
            }
        });
    }

    public JButton getComment() {
        return comment;
    }

    public int getSelected() {
        return Integer.parseInt(data.elementAt(sm.getMinSelectionIndex()).elementAt(0));
    }
}
