package view.actions.borrow;

import logic.Portal.Portal;
import logic.object.Borrow;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class BorrowConfirmation extends Panel {
    JButton confirm;
    ListSelectionModel lsm;
    Vector<Borrow> vec;
    JScrollPane scrollPane;
    JTable table;

    public BorrowConfirmation(Portal portal) {
        super(portal);

        Label inbox = new Label("Your Borrow Requests");
        inbox.setBounds(20, 30, 220, 50);
        inbox.setFont(font);
        add(inbox);
        vec = portal.getBorrowRequests((portal).getId());
        for (Borrow b : vec){
            b.setBookName(portal.getBookById(b.getBookId()).getName());
        }
        Vector<Vector<String >> data = Borrow.getRows(vec);
        table = new JTable(new MyTableModel(data , Borrow.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        lsm = table.getSelectionModel();

        confirm = new JButton("Confirm Borrow");
        add(confirm);
        confirm.setFont(font);
        confirm.setBounds(350, 550, 200, 50);
        confirm.setEnabled(false);

        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    confirm.setEnabled(false);

                } else {
                    confirm.setEnabled(true);
                }
            }
        });
    }

    public JButton getConfirm() {
        return confirm;
    }

    public Borrow getSelected(){
        return vec.elementAt(lsm.getMinSelectionIndex());
    }

    public Vector<Borrow> getVec() {
        return vec;
    }

    public ListSelectionModel getLsm() {
        return lsm;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void remake() {
        remove(scrollPane);
        vec = portal.getBorrowRequests((portal).getId());
        for (Borrow b : vec){
            b.setBookName(portal.getBookById(b.getBookId()).getName());
        }
        Vector<Vector<String >> data = Borrow.getRows(vec);
        table = new JTable(new MyTableModel(data , Borrow.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        lsm = table.getSelectionModel();
        setVisible(true);
    }
}