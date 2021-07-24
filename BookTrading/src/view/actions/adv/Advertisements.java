package view.actions.adv;

import logic.Portal.Portal;
import logic.object.Advertisement;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class Advertisements extends Panel {
    JButton profile;
    ListSelectionModel sm;
    Vector<Vector<String >> data;
    Vector<Advertisement> vec;

    public Advertisements(Portal portal) {
        super(portal);

        Label adsLabel = new Label("Advertisements");
        adsLabel.setBounds(20, 40, 150, 50);
        adsLabel.setFont(font);
        add(adsLabel);
        vec = portal.getAdvertisements();
        for (Advertisement a : vec){
            a.setBookName(portal.getBookById(a.getBookId()).getName());
        }
        data = Advertisement.getRows(vec);
        JTable table = new JTable(new MyTableModel(data, Advertisement.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        sm = table.getSelectionModel();


        profile = new JButton("View Profile");
        add(profile);
        profile.setFont(font);
        profile.setBounds(350, 550, 200, 50);
        profile.setEnabled(false);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {

                    profile.setEnabled(false);
                } else {

                    profile.setEnabled(true);
                }
            }
        });
    }

    public int getSelected() {
        return vec.elementAt(sm.getMinSelectionIndex()).getId();
    }

    public JButton getProfile() {
        return profile;
    }
}
