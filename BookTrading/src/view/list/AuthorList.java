package view.list;

import logic.Portal.Portal;
import logic.object.Author;
import view.basic.MiniPage;
import view.basic.MyTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AuthorList extends MiniPage {
    JButton add;
    Vector<Vector<String >> data;
    ListSelectionModel sm;

    public AuthorList(Portal portal) throws HeadlessException {
        super(portal);
        Vector<Author> authors = portal.getAuthors();
        data = Author.getRows(authors);
        JTable table = new JTable(new MyTableModel(data , Author.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(10, 10, 380, 250);
        sm = table.getSelectionModel();

        add = new JButton("Add");
        add(add);
        add.setFont(font);
        add.setBounds(150, 300, 100, 50);
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
