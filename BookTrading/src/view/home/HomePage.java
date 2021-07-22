package view.home;

import logic.Portal.Portal;
import view.basic.Page;
import view.basic.Panel;

import java.awt.*;

public abstract class HomePage extends Panel {

    public HomePage(Portal portal) throws HeadlessException {
        super(portal);
    }
}
