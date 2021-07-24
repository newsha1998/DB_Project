package view.actions.wallet;

import logic.Portal.Portal;
import logic.object.Wallet;
import view.basic.MiniPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserWallet extends MiniPage {
    JButton increase, withdraw;
    JTextField available, blocked;
    Wallet wallet;

    public UserWallet(Portal portal, Wallet wallet) {
        super(portal);
        this.wallet = wallet;

        Label availableLabel = new Label("Available Credit:");
        add(availableLabel);
        availableLabel.setFont(font);
        availableLabel.setBounds(20, 40, 180, 30);

        available = new JTextField();
        add(available);
        available.setFont(font);
        available.setEditable(false);
        available.setBounds(200, 40, 150, 30);
        available.setText(String.valueOf(wallet.getAvailableCredit()));


        Label blockedLabel = new Label("Blocked Credit:");
        add(blockedLabel);
        blockedLabel.setFont(font);
        blockedLabel.setBounds(20, 90, 180, 30);

        blocked = new JTextField();
        add(blocked);
        blocked.setFont(font);
        blocked.setEditable(false);
        blocked.setBounds(200, 90, 150, 30);
        blocked.setText(String.valueOf(wallet.getBlockedCredit()));

        increase = new JButton("Increase Credit");
        increase.setFont(font);
        add(increase);
        increase.setBounds(100, 190, 200, 50);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(font);
        add(withdraw);
        withdraw.setBounds(100, 260, 200, 50);

        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction transaction = new Transaction(portal);
                transaction.getDone().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION){
                            portal.AddTransaction(Double.valueOf(transaction.getAmount().getText()),
                                    "IncreaseAmanat", transaction.getDescription().getText());
                            portal.IncreaseCredit(wallet, Double.valueOf(transaction.getAmount().getText()));
                            available.setText(wallet.getAvailableCredit() + "");
                            available.setVisible(true);

                            JOptionPane.showMessageDialog(getParent(),
                                    "done successfully",
                                    "",
                                    JOptionPane.PLAIN_MESSAGE);
                            transaction.setVisible(false);
                        }
                    }
                });

            }


        });

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transaction transaction = new Transaction(portal);
                transaction.getDone().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION){


                            if(portal.getWallet(portal.getId()).getAvailableCredit() >= Double.valueOf(transaction.getAmount().getText())) {
                                portal.AddTransaction(Double.valueOf(transaction.getAmount().getText()), "WithdrawAmanat",
                                        transaction.getDescription().getText());
                                portal.DecreaseCredit(wallet, Double.valueOf(transaction.getAmount().getText()));
                                available.setText(wallet.getAvailableCredit() + "");
                                available.setVisible(true);
                                JOptionPane.showMessageDialog(getParent(),
                                        "done successfully",
                                        "",
                                        JOptionPane.PLAIN_MESSAGE);
                            }

                            else {
                                JOptionPane.showMessageDialog(getParent(),
                                        "Not Enough Credit",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            transaction.setVisible(false);
                        }
                    }
                });

            }

        });



    }

    public JButton getIncrease() {
        return increase;
    }

    public void setIncrease(JButton increase) {
        this.increase = increase;
    }

    public JButton getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(JButton withdraw) {
        this.withdraw = withdraw;
    }

    public JTextField getAvailable() {
        return available;
    }

    public void setAvailable(JTextField available) {
        this.available = available;
    }

    public JTextField getBlocked() {
        return blocked;
    }

    public void setBlocked(JTextField blocked) {
        this.blocked = blocked;
    }

    public void SetWallet(Wallet wallet){
        available.setText(String.valueOf(wallet.getAvailableCredit()));
        blocked.setText(String.valueOf(wallet.getBlockedCredit()));
    }
}
