
package view.actions;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import logic.object.Advertisement;
import logic.object.User;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class RemoveAdvertisement extends Panel{
    JButton remove;
    ListSelectionModel sm;
    Vector<Vector<String >> data;
    Vector<Advertisement> vec;
    JScrollPane scrollPane;
    JTable table;


    public RemoveAdvertisement(Portal portal) {
        super(portal);

        Label adsLabel = new Label("Your Advertisements");
        adsLabel.setBounds(20, 40, 180, 50);
        adsLabel.setFont(font);
        add(adsLabel);
        vec = portal.getUserAdvertisements(((UserPortal)portal).getId());
        for (Advertisement a : vec){
            a.setBookName(portal.getBookById(a.getBookId()).getName());

        }
        data = Advertisement.getRows(vec);
        for (Vector<String> v : data){
            v.remove(0);
        }
        Vector<String> columns = Advertisement.getColumns();
        columns.remove(0);
        table = new JTable(new MyTableModel(data, columns));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        sm = table.getSelectionModel();


        remove = new JButton("Remove");
        add(remove);
        remove.setFont(font);
        remove.setBounds(350, 550, 200, 50);
        remove.setEnabled(false);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {

                    remove.setEnabled(false);
                } else {

                    remove.setEnabled(true);
                }
            }
        });
    }

    public JButton getRemove() {
        return remove;
    }

    public int getSelectedId(){
        return vec.elementAt(sm.getMinSelectionIndex()).getId();
    }

    public void remake() {
        remove(scrollPane);
        vec = portal.getUserAdvertisements(((UserPortal)portal).getId());
        for (Advertisement a : vec){
            a.setBookName(portal.getBookById(a.getBookId()).getName());

        }
        data = Advertisement.getRows(vec);
        for (Vector<String> v : data){
            v.remove(0);
        }
        Vector<String> columns = Advertisement.getColumns();
        columns.remove(0);
        table = new JTable(new MyTableModel(data, columns));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        sm = table.getSelectionModel();
        setVisible(true);
    }
}
