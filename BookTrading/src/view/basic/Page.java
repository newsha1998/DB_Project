package view.basic;

import logic.Portal.Portal;
import logic.Portal.UserPortal;
import logic.object.Bookstore;
import view.actions.*;
import view.actions.comment.CommentForBook;
import view.actions.comment.CommentForBookstore;
import view.actions.comment.CommentForUser;
import view.home.UserHomePage;
import view.list.BookList;
import view.list.BookstoreList;
import view.list.UserList;
import view.profile.BookstoreProfile;
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
        setResizable(false);
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

        JMenuItem viewBookstore = new JMenuItem("View Bookstore's List");
        view.add(viewBookstore);
        viewBookstore.setFont(font);
        viewBookstore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookstoreList bookstores = new BookstoreList(portal);
                setContentPane(bookstores);
                bookstores.getProfile().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BookstoreProfile bookstoreProfile = new BookstoreProfile(portal, bookstores.getSelected());
                        setContentPane(bookstoreProfile);
                        setVisible(true);
                    }
                });
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
                                            "Done successfully",
                                            "",
                                            JOptionPane.PLAIN_MESSAGE);
                                    rm.setReplyText("");
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
        borrow.add(confirmation);confirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowConfirmation bc = new BorrowConfirmation(portal);
                setContentPane(bc);
                bc.getConfirm().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION) {
                            portal.ConfirmBorrow(bc.getSelected().getId());
                            JOptionPane.showMessageDialog(getParent(),
                                    "done successfully",
                                    "",
                                    JOptionPane.PLAIN_MESSAGE);
                            bc.remake();
                        }
                    }
                });
            }
        });

        borrowReq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowRequest br = new BorrowRequest(portal);
                setContentPane(br);
                br.getAddReq().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION){
                            int ret = portal.AddBorrowReq(((UserPortal)portal).getId(), br.getUsername().getText(), Integer.valueOf(br.getBookId().getText()),
                                    Double.valueOf(br.getPrice().getText()), br.getStartDate().getText(), br.getDeadlineDate().getText(), Double.valueOf(br.getDelay().getText()),
                                    Double.valueOf(br.getGuarantee().getText()), br.getAddress().getText(), br.getDescription().getText());
                            if(ret == -1) {
                                JOptionPane.showMessageDialog(getParent(),
                                        "This Username doesn't exist",
                                        "",
                                        JOptionPane.PLAIN_MESSAGE);
                            }
                            else if(ret == -2){
                                JOptionPane.showMessageDialog(getParent(),
                                        "This Book Id doesn't exist!",
                                        "ERROR",
                                        JOptionPane.PLAIN_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(getParent(),
                                        "done successfully",
                                        "",
                                        JOptionPane.PLAIN_MESSAGE);
                                br.getAddress().setText(null); br.getBookId().setText(null); br.getDeadlineDate().setText(null);
                                br.getDelay().setText(null); br.getDescription().setText(null); br.getGuarantee().setText(null);
                                br.getPrice().setText(null); br.getStartDate().setText(null); br.getUsername().setText(null);
                            }


                        }
                    }
                });
            }
        });


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

        JMenu comment = new JMenu("Comment");
        comment.setFont(font);
        action.add(comment);
        JMenuItem commentUser = new JMenuItem("Comment For User");
        commentUser.setFont(font);
        comment.add(commentUser);
        commentUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentForUser commentForUser = new CommentForUser(portal);
            }
        });
        JMenuItem commentBook = new JMenuItem("Comment For Book");
        commentBook.setFont(font);
        comment.add(commentBook);
        commentBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentForBook commentForBook = new CommentForBook(portal);
            }
        });
        JMenuItem commentBookstore = new JMenuItem("Comment For Bookstore");
        commentBookstore.setFont(font);
        comment.add(commentBookstore);
        commentBookstore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentForBookstore commentForBook = new CommentForBookstore(portal);
            }
        });

        JMenu advertisement = new JMenu("Advertisement");
        advertisement.setFont(font);
        action.add(advertisement);
        JMenuItem AddAdvertisement = new JMenuItem("Add Advertisement");
        AddAdvertisement.setFont(font);
        advertisement.add(AddAdvertisement);
        AddAdvertisement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAdvertisement adver = new AddAdvertisement((UserPortal)portal);

            }
        });

        JMenuItem removeAd = new JMenuItem("Remove Advertisement");
        removeAd.setFont(font);
        advertisement.add(removeAd);
        removeAd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveAdvertisement ra = new RemoveAdvertisement(portal);
                setContentPane(ra);
                ra.getRemove().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION) {
                            portal.RemoveAd(ra.getSelectedId());
                            JOptionPane.showMessageDialog(getParent(),
                                    "done successfully",
                                    "",
                                    JOptionPane.PLAIN_MESSAGE);
                            ra.remake();
                        }
                    }
                });
            }
        });

        JMenuItem getAdvertisements = new JMenuItem("View Advertisements");
        getAdvertisements.setFont(font);
        view.add(getAdvertisements);
        getAdvertisements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Advertisements ads = new Advertisements(portal);
                setContentPane(ads);
                ads.getProfile().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UserProfile userProfile = new UserProfile(portal, ads.getSelected());
                        setContentPane(userProfile);
                    }
                });
            }
        });


    }
}
