package View.Actions;

import Logic.Portals.MemberPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class BorrowReq extends JFrame {
    MemberPortal portal;
    static int x = 300, y = 400;

    public BorrowReq(MemberPortal portal) throws HeadlessException {
        this.portal = portal;
        this.portal = portal;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null);

        Label len = new Label("Lender ID");
        len.setBounds(10, 20, 100, 20);
        add(len);
        TextField lender = new TextField();
        lender.setBounds(120, 20, 150, 20);
        add(lender);

        Label bo = new Label("Book ID");
        bo.setBounds(10, 50, 100, 20);
        add(bo);
        TextField book = new TextField();
        book.setBounds(120, 50, 150, 20);
        add(book);

        Label pr = new Label("Price");
        pr.setBounds(10, 80, 100, 20);
        add(pr);
        TextField price = new TextField();
        price.setBounds(120, 80, 150, 20);
        add(price);

        Label st = new Label("Start Date");
        st.setBounds(10, 110, 100, 20);
        add(st);
        TextField sdate = new TextField();
        sdate.setBounds(120, 110, 150, 20);
        add(sdate);

        Label dl = new Label("Deadline");
        dl.setBounds(10, 140, 100, 20);
        add(dl);
        TextField dead = new TextField();
        dead.setBounds(120, 140, 150, 20);
        add(dead);

        Label jar = new Label("Delay Penalty");
        jar.setBounds(10, 170, 100, 20);
        add(jar);
        TextField delay = new TextField();
        delay.setBounds(120, 170, 150, 20);
        add(delay);

        Label gr = new Label("Guarantee");
        gr.setBounds(10, 200, 100, 20);
        add(gr);
        TextField gar = new TextField();
        gar.setBounds(120, 200, 150, 20);
        add(gar);

        Label ad = new Label("Address");
        ad.setBounds(10, 230, 100, 20);
        add(ad);
        TextField adr = new TextField();
        adr.setBounds(120, 230, 150, 20);
        add(adr);

        Label de = new Label("Description");
        de.setBounds(10, 260, 100, 20);
        add(de);
        TextField des = new TextField();
        des.setBounds(120, 260, 150, 20);
        add(des);

        JButton sub = new JButton("Submit");
        add(sub);
        sub.setBounds(130, 310, 100, 30);
        setVisible(true);

        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = portal.borrowreq(Integer.parseInt(lender.getText()),
                        Integer.parseInt(book.getText()),
                        Double.parseDouble(price.getText()),
                        sdate.getText(),
                        dead.getText(),
                        Double.parseDouble(delay.getText()),
                        Double.parseDouble(gar.getText()),
                        adr.getText(), des.getText());
                JOptionPane.showMessageDialog(getParent(),
                        "You Borrow Request ID is " + r,
                        "Submit Request",
                        JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
            }
        });
    }
}
