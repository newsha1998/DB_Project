package View;

import Logic.Portals.MemberPortal;
import Logic.Portals.Portal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberPage extends Page{
    public MemberPage(MemberPortal port) {
        super(port);
        comboBox.addItem("Send A Message to A User");
        comboBox.addItem("Read Messages");
        comboBox.addItem("Borrow Request");
        comboBox.addItem("Accept Borrow Req");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Send A Message to A User") {
                    MessageBox messageBox = new MessageBox(port);
                }
                if (comboBox.getSelectedItem() == "Read Messages") {
                    ReadMessages readMessages = new ReadMessages(port);
                }
                if (comboBox.getSelectedItem() == "Borrow Request") {
                    BorrowReq borrowReq = new BorrowReq(port);
                }
                if (comboBox.getSelectedItem() == "Accept Borrow Req") {
                    Accept accept = new Accept(port);
                }
            }
        });
    }
}
