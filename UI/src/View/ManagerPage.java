package View;

import Logic.Portals.ManagerPortal;
import Logic.Portals.MemberPortal;
import Logic.Portals.Portal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPage extends Page {
    public ManagerPage(Portal portal) {
        super(portal);
        comboBox.addItem("Add Employee");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Send A Message to A User") {
                    EmployeeReg employeeReg = new EmployeeReg((ManagerPortal) portal);
                }
            }
        });
    }
}
