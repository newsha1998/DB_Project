package view.basic;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import view.SendMessage;
import view.UserList;
import view.profile.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Page extends JFrame {
    static int x = 900, y = 700;
    protected Portal portal;
    protected JMenuBar menuBar;
    protected JMenu edit, action, view;
    protected Font font;

    public Page(Portal portal) throws HeadlessException {
        this.portal = portal;
        setSize(x, y);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        font = new Font("SansSerif", Font.PLAIN, 20);
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        setJMenuBar(menuBar);

        action = new JMenu("Actions");
        action.setFont(font);
        menuBar.add(action);

        view = new JMenu("View");
        view.setFont(font);
        menuBar.add(view);

        edit = new JMenu("Edit");
        edit.setFont(font);
        menuBar.add(edit);

        addItems();
        setVisible(true);
    }

    private void addItems() {
        if (portal instanceof UserPortal) {
            createUserMenuBar();
        }
    }

    private void createUserMenuBar() {
        JMenu messages = new JMenu("Messages");
        messages.setFont(font);
        action.add(messages);

        JMenuItem sendMessage = new JMenuItem("Send Message");
        sendMessage.setFont(font);
        messages.add(sendMessage);
        JMenuItem inbox = new JMenuItem("View Inbox");
        inbox.setFont(font);
        messages.add(inbox);

        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage send = new SendMessage((UserPortal)portal);
            }
        });

        JMenu borrow = new JMenu("Borrow");
        borrow.setFont(font);
        action.add(borrow);

        JMenuItem borrowReq = new JMenuItem("Borrow Request");
        borrowReq.setFont(font);
        borrow.add(borrowReq);
        JMenuItem confirmation = new JMenuItem("Confirm Borrow Request");
        confirmation.setFont(font);
        borrow.add(confirmation);

        JMenuItem userList = new JMenuItem("View User's List");
        userList.setFont(font);
        view.add(userList);
        userList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserList userList = new UserList(portal);
                setContentPane(userList);
                userList.getProfile().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setContentPane(new UserProfile(portal, userList.getSelected()));
                    }
                });
            }
        });
    }
}
