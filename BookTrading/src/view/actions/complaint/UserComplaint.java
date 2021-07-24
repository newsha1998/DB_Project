package view.actions.complaint;

import logic.Portal.Portal;
import logic.object.Complaint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserComplaint extends ComplaintPage {
    public UserComplaint(Portal portal) throws HeadlessException {
        super(portal);
        usernameLabel.setText("Username:");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Complaint complaint = new Complaint();
                complaint.setPlaintiffId(portal.getId());
                complaint.setrId(portal.getUsetIdByUsername(username.getText()));
                complaint.setDoc(doc.getText());
                complaint.setText(text.getText());
                complaint.setSub(subject.getText());
                portal.insertComplaint(complaint);
            }
        });
    }
}
