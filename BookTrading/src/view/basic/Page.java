package view.basic;

import logic.Portal.BookstorePortal;
import logic.Portal.ManagerPortal;
import logic.Portal.Portal;
import logic.Portal.UserPortal;
import logic.object.Bookstore;
import logic.object.Wallet;
import view.actions.adv.AddAdvertisement;
import view.actions.adv.Advertisements;
import view.actions.adv.RemoveAdvertisement;
import view.actions.borrow.BorrowConfirmation;
import view.actions.borrow.BorrowRequest;
import view.actions.buy.BuyConfirmation;
import view.actions.buy.BuyFromUser;
import view.actions.comment.CommentForBook;
import view.actions.comment.CommentForBookstore;
import view.actions.comment.CommentForUser;
import view.actions.complaint.BookstoreComplaint;
import view.actions.complaint.UserComplaint;
import view.actions.insert.AddBook;
import view.actions.insert.AddEmployee;
import view.actions.message.ReadMessage;
import view.actions.message.ReceiveMessage;
import view.actions.message.SendMessage;
import view.actions.wallet.UserWallet;
import view.home.BookstoreHomePage;
import view.home.ManagerHomePage;
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
        if (portal instanceof ManagerPortal) {
            createManagerMenuBar();
        }

        JMenuItem editProfile = new JMenuItem("Edit Profile");
        editProfile.setFont(font);
        edit.add(editProfile);
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (portal instanceof UserPortal)
                    setContentPane(new UserHomePage((UserPortal) portal));
                if (portal instanceof ManagerPortal)
                    setContentPane(new ManagerHomePage((ManagerPortal) portal));
                if (portal instanceof BookstorePortal)
                    setContentPane(new BookstoreHomePage((BookstorePortal) portal));
                setVisible(true);
            }
        });
        JMenuItem changePass = new JMenuItem("Change Password");
        edit.add(changePass);
        changePass.setFont(font);
    }

    private void createManagerMenuBar() {
        JMenu addEmployee = new JMenu("Add Employee");
        addEmployee.setFont(font);
        action.add(addEmployee);
        JMenuItem addSupporter = new JMenuItem("Add Support Agent");
        addSupporter.setFont(font);
        addEmployee.add(addSupporter);
        JMenuItem addAccountant = new JMenuItem("Add Accountant");
        addAccountant.setFont(font);
        addEmployee.add(addAccountant);
        addAccountant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee addEmployee1 = new AddEmployee(portal, false);
            }
        });
        addSupporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee addEmployee1 = new AddEmployee(portal, true);
            }
        });
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
                view.actions.adv.AddAdvertisement adver = new AddAdvertisement((UserPortal)portal);

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

        JMenu complaint = new JMenu("Complaint");
        complaint.setFont(font);
        action.add(complaint);
        JMenuItem complaintUser = new JMenuItem("Complaint User");
        complaintUser.setFont(font);
        complaint.add(complaintUser);
        complaintUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserComplaint userComplaint = new UserComplaint(portal);
            }
        });
        JMenuItem complaintBookstore = new JMenuItem("Complaint Bookstore");
        complaintBookstore.setFont(font);
        complaint.add(complaintBookstore);
        complaintBookstore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookstoreComplaint userComplaint = new BookstoreComplaint(portal);
            }
        });
        JMenu buy = new JMenu("Buy");
        buy.setFont(font);
        action.add(buy);
        JMenuItem buyFromUser = new JMenuItem("Buy From User");
        JMenuItem buyFromBookstore = new JMenuItem("Buy From Bookstore");
        JMenuItem buyRequests = new JMenuItem("Confirm Buy Request");
        buyFromUser.setFont(font);
        buyFromBookstore.setFont(font);
        buyRequests.setFont(font);
        buy.add(buyFromUser);
        buy.add(buyFromBookstore);
        buy.add(buyRequests);
        buyFromUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyFromUser bu = new BuyFromUser(portal);
                bu.getBuy().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION){
                            bu.setBuyParametrs();
                            portal.AddBuyFromUser(bu.getB());
                            JOptionPane.showMessageDialog(getParent(),
                                    "Buy Request Sent",
                                    "",
                                    JOptionPane.PLAIN_MESSAGE);
                            bu.getDeliveryAddress().setText(null); bu.getBook().setText(null); bu.getDescription().setText(null);
                            bu.getDeliveryAddress().setText(null); bu.getUsername().setText(null); bu.getPrice().setText(null);

                        }
                    }
                });
            }

        });

        buyRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyConfirmation bc = new BuyConfirmation(portal);
                setContentPane(bc);
                bc.getConfirm().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION) {
                            if((portal.getWallet(bc.getSelected().getBuyerId())).getAvailableCredit()>= bc.getSelected().getPrice()){
                                portal.ConfirmBuy(bc.getSelected());
                                JOptionPane.showMessageDialog(getParent(),
                                        "done successfully",
                                        "",
                                        JOptionPane.PLAIN_MESSAGE);
                                portal.DecreaseCredit(portal.getWallet(bc.getSelected().getBuyerId()), bc.getSelected().getPrice());
                                portal.IncreaseCredit(portal.getWallet(bc.getSelected().getSellerId()), bc.getSelected().getPrice());
                                bc.remake();
                            }
                            else{
                                JOptionPane.showMessageDialog(getParent(),
                                        "Not Enough Credit For Buyer",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }
                });
            }
        });
        JMenuItem wallet = new JMenuItem("Wallet");
        wallet.setFont(font);
        view.add(wallet);
        wallet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserWallet userWallet = new UserWallet(portal);
                Wallet wallet = portal.getWallet(portal.getId());
                userWallet.SetWallet(wallet);
            }
        });

    }
}
