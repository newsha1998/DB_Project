package view.list;

import logic.Portal.Portal;
import logic.object.User;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class UserList extends Panel {
    JButton profile, report, message;
    ListSelectionModel sm;
    Vector<Vector<String >> data;

    public UserList(Portal portal) {
        super(portal);

        Label userListLabel = new Label("User's List");
        userListLabel.setBounds(20, 40, 150, 50);
        userListLabel.setFont(font);
        add(userListLabel);
        Vector <User> vec = portal.getAllUsers();
        data = User.getRows(vec);
        JTable table = new JTable(new MyTableModel(data , User.getColumns()));
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
        profile.setBounds(100, 550, 200, 50);

        message = new JButton("Send Message");
        add(message);
        message.setFont(font);
        message.setBounds(350, 550, 200, 50);

        report = new JButton("Report");
        add(report);
        report.setFont(font);
        report.setBounds(600, 550, 200, 50);

        profile.setEnabled(false);
        report.setEnabled(false);
        message.setEnabled(false);
        sm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    profile.setEnabled(false);
                    report.setEnabled(false);
                    message.setEnabled(false);
                } else {
                    profile.setEnabled(true);
                    report.setEnabled(true);
                    message.setEnabled(true);
                }
            }
        });
    }

    public JButton getProfile() {
        return profile;
    }

    public JButton getReport() {
        return report;
    }

    public JButton getMessage() {
        return message;
    }

    public int getSelected() {
        return Integer.parseInt(data.elementAt(sm.getMinSelectionIndex()).elementAt(0));
    }

    public int getSelectedUsername() {
        return Integer.parseInt(data.elementAt(sm.getMinSelectionIndex()).elementAt(1));
    }
}
