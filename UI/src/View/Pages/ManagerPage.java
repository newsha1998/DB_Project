package View.Pages;

import Logic.Portals.ManagerPortal;
import Logic.Portals.Portal;
import View.Actions.EmployeeReg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPage extends Page {
    public ManagerPage(Portal portal) {
        super(portal);
        comboBox.addItem("Add Employee");
        comboBox.addItem("Monitor Employee");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Add Employee") {
                    EmployeeReg employeeReg = new EmployeeReg((ManagerPortal) portal);
                }
            }
        });
    }
}
