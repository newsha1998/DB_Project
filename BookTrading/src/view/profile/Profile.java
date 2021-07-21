package view.profile;

import logic.Portal.Portal;
import view.Page;

import java.awt.*;

public abstract class Profile extends Page {
    int id;
    Font font = new Font("SansSerif", Font.PLAIN, 20);

    public Profile(Portal portal, int id) throws HeadlessException {
        super(portal);
        this.id = id;
    }
}
