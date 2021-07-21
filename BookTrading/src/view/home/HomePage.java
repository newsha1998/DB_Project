package view.home;

import logic.Portal.Portal;
import view.Page;

import java.awt.*;

public abstract class HomePage extends Page {
    Font font = new Font("SansSerif", Font.PLAIN, 20);

    public HomePage(Portal portal) throws HeadlessException {
        super(portal);
    }
}
