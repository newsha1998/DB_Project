package view.basic;

import view.home.UserHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ModifyedActionListener implements ActionListener {
    protected UserHomePage homePage;

    public ModifyedActionListener(UserHomePage homePage) {
        this.homePage = homePage;
    }
}
