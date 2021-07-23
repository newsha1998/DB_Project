package view.actions;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import logic.object.Message;
import logic.object.User;
import view.basic.MyTableModel;
import view.basic.Panel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class ReceiveMessage extends Panel {
    JButton openMessage;
    ListSelectionModel lsm;
    Vector <Message> vec;

    public ReceiveMessage(Portal portal) {
        super(portal);

        Label inbox = new Label("Your inbox messages");
        inbox.setBounds(20, 40, 250, 50);
        inbox.setFont(font);
        add(inbox);
        vec = portal.getUserMessages(((UserPortal)portal).getId());
        Vector<Vector<String >> data = Message.getRows(vec);
        JTable table = new JTable(new MyTableModel(data , Message.getColumns()));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setFont(font);
        add(scrollPane);
        scrollPane.setBounds(50, 100, 800, 400);
        lsm = table.getSelectionModel();

        openMessage = new JButton("Open Message");
        add(openMessage);
        openMessage.setFont(font);
        openMessage.setBounds(350, 550, 200, 50);
        openMessage.setEnabled(false);

        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    openMessage.setEnabled(false);

                } else {
                    openMessage.setEnabled(true);
                }
            }
        });


    }

    public JButton getOpen() {
        return openMessage;
    }

    public String getText(){
        return vec.elementAt(lsm.getMinSelectionIndex()).getText();
    }

    public String getSubject(){
        return vec.elementAt(lsm.getMinSelectionIndex()).getSubject();
    }

    public String getUsername(){
        return vec.elementAt(lsm.getMinSelectionIndex()).getSenderUsername();
    }
}
