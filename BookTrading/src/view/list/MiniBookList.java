package view.list;

import logic.Portal.Portal;
import logic.object.Author;
import logic.object.Book;
import view.basic.MiniPage;
import view.basic.MyTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MiniBookList extends MiniPage {
    JButton add;
    Vector<Vector<String >> data;
    ListSelectionModel sm;

    public MiniBookList(Portal portal) throws HeadlessException {
        super(portal);
        Vector<Book> books = portal.getAllBooks();
        data = Book.getMiniRows(portal, books);
        JTable table = new JTable(new MyTableModel(data , Book.getMiniColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(10, 10, 380, 250);
        sm = table.getSelectionModel();

        add = new JButton("Select");
        add(add);
        add.setFont(font);
        add.setBounds(150, 300, 100, 50);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public JButton getAdd() {
        return add;
    }

    public ListSelectionModel getSm() {
        return sm;
    }

    public int getSelected() {
        return Integer.parseInt(data.elementAt(sm.getMinSelectionIndex()).elementAt(0));
    }
}
