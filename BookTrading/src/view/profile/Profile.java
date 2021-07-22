package view.profile;

import logic.Portal.Portal;
import view.basic.Page;
import view.basic.Panel;

import java.awt.*;

public abstract class Profile extends Panel {
    protected int id;

    public Profile(Portal portal, int id) throws HeadlessException {
        super(portal);
        this.id = id;
    }
}
