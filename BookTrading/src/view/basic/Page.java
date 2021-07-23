package view.basic;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import view.ReadMessage;
import view.actions.AddBook;
import view.actions.ReceiveMessage;
import view.actions.SendMessage;
import view.home.UserHomePage;
import view.list.BookList;
import view.list.UserList;
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
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.setFont(font);
        action.add(addBook);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new AddBook(portal));
            }
        });

        JMenuItem viewBook = new JMenuItem("View Book's List");
        view.add(viewBook);
        viewBook.setFont(font);
        viewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new BookList(portal));
            }
        });

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
        inbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceiveMessage message = new ReceiveMessage(portal);
                setContentPane(message);
                message.getOpen().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ReadMessage rm = new ReadMessage(portal);
                        rm.getText().setText(message.getText());
                        rm.getUsername().setText(message.getUsername());
                        rm.getSubject().setText(message.getSubject());
                        setContentPane(rm);
                        rm.getMessage().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                        "Confirmation", JOptionPane.YES_NO_OPTION);
                                if(result == JOptionPane.YES_OPTION){
                                    ((UserPortal)portal).SendMessage(((UserPortal)portal).getId(), message.getUsername(), message.getSubject(), rm.getReplyText());
                                    JOptionPane.showMessageDialog(getParent(),
                                            "Message has been sent successfully",
                                            "",
                                            JOptionPane.PLAIN_MESSAGE);

                                }
                            }
                        });
                    }
                });
            }
        });


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
                        UserProfile userProfile = new UserProfile(portal, userList.getSelected());
                        setContentPane(userProfile);
                        userProfile.getSend_message_button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                SendMessage send = new SendMessage((UserPortal)portal);
                                send.SetUsername(userList.getSelectedUsername());
                            }
                        });
                    }
                });
                userList.getMessage().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SendMessage send = new SendMessage((UserPortal)portal);
                        send.SetUsername(userList.getSelectedUsername());
                    }
                });

            }
        });

        JMenuItem editProfile = new JMenuItem("Edit Profile");
        editProfile.setFont(font);
        edit.add(editProfile);
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(new UserHomePage((UserPortal) portal));
                setVisible(true);
            }
        });
    }
}
