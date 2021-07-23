package view.actions;

import logic.Portal.Portal;
import logic.object.Book;
import view.basic.Panel;
import view.list.AuthorList;
import view.list.InterpreterList;
import view.list.PublisherList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class AddBook extends Panel {
    Vector <Integer> authors= new Vector<Integer>() , interpreters = new Vector<Integer>();
    int publisherId = 0;

    public AddBook(Portal portal) {
        super(portal);
        Book book = new Book();

        Label nameLabel = new Label("Name:");
        nameLabel.setFont(font);
        add(nameLabel);
        nameLabel.setBounds(20, 50, 150, 50);

        JTextField name = new JTextField();
        name.setFont(font);
        add(name);
        name.setBounds(200, 50, 150, 50);

        Label genreLabel = new Label("Genre:");
        genreLabel.setFont(font);
        add(genreLabel);
        genreLabel.setBounds(20, 110, 150, 50);

        JTextField genre = new JTextField();
        genre.setFont(font);
        add(genre);
        genre.setBounds(200, 110, 150, 50);

        Label langLabel = new Label("Language:");
        langLabel.setFont(font);
        add(langLabel);
        langLabel.setBounds(20, 170, 150, 50);

        JTextField lang = new JTextField();
        lang.setFont(font);
        add(lang);
        lang.setBounds(200, 170, 150, 50);

        Label relLabel = new Label("Release Date:");
        relLabel.setFont(font);
        add(relLabel);
        relLabel.setBounds(20, 230, 150, 50);

        JTextField reldate = new JTextField();
        reldate.setFont(font);
        add(reldate);
        reldate.setBounds(200, 230, 150, 50);


        Label matLabel = new Label("Material:");
        matLabel.setFont(font);
        add(matLabel);
        matLabel.setBounds(20, 290, 150, 50);

        JTextField mat = new JTextField();
        mat.setFont(font);
        add(mat);
        mat.setBounds(200, 290, 150, 50);

        Label serLabel = new Label("Series Number:");
        serLabel.setFont(font);
        add(serLabel);
        serLabel.setBounds(20, 350, 155, 50);

        JTextField ser = new JTextField();
        ser.setFont(font);
        add(ser);
        ser.setBounds(200, 350, 150, 50);

        Label desLabel = new Label("Description:");
        desLabel.setFont(font);
        add(desLabel);
        desLabel.setBounds(20, 410, 150, 50);

        JTextArea des = new JTextArea();
        des.setFont(font);
        des.setLineWrap(true);
        des.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(des);
        add(sp);
        sp.setBounds(20, 470, 330, 150);

        Label catLabel = new Label("Category:");
        catLabel.setFont(font);
        add(catLabel);
        catLabel.setBounds(400, 50, 155, 50);

        JTextField cat = new JTextField();
        cat.setFont(font);
        add(cat);
        cat.setBounds(580, 50, 150, 50);

        Label sizeLabel = new Label("Size:");
        sizeLabel.setFont(font);
        add(sizeLabel);
        sizeLabel.setBounds(400, 110, 155, 50);

        JTextField size = new JTextField();
        size.setFont(font);
        add(size);
        size.setBounds(580, 110, 150, 50);

        Label sumLabel = new Label("Summary:");
        sumLabel.setFont(font);
        add(sumLabel);
        sumLabel.setBounds(400, 170, 150, 50);

        JTextArea sum = new JTextArea();
        sum.setFont(font);
        sum.setLineWrap(true);
        sum.setWrapStyleWord(true);
        JScrollPane sp2 = new JScrollPane(sum);
        add(sp2);
        sp2.setBounds(400, 230, 330, 150);

        JButton setPublisher = new JButton("Set Publisher");
        setPublisher.setFont(font);
        setPublisher.setBounds(400, 400, 330, 50);
        add(setPublisher);
        setPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PublisherList authorList = new PublisherList(portal);
                authorList.getAdd().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        publisherId = authorList.getSelected();
                    }
                });
            }
        });


        JButton addAuthor = new JButton("Add Author");
        addAuthor.setFont(font);
        addAuthor.setBounds(400, 460, 330, 50);
        add(addAuthor);
        addAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuthorList authorList = new AuthorList(portal);
                authorList.getAdd().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id = authorList.getSelected();
                        authors.add(id);
                    }
                });
            }
        });

        JButton addInterpreter = new JButton("Add Interpreter");
        addInterpreter.setFont(font);
        addInterpreter.setBounds(400, 520, 330, 50);
        add(addInterpreter);
        addInterpreter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterpreterList authorList = new InterpreterList(portal);
                authorList.getAdd().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id = authorList.getSelected();
                        interpreters.add(id);
                    }
                });
            }
        });

        JButton submit = new JButton("Submit");
        submit.setFont(font);
        submit.setBounds(700, 600, 150, 50);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Integer> unique = new HashSet<Integer>(authors);
                authors = new Vector<>(unique);
                unique = new HashSet<Integer>(interpreters);
                interpreters = new Vector<>(unique);
                boolean ret = portal.insertBook(new Book(publisherId,
                        ser.getText(), name.getText(), genre.getText(), lang.getText(), reldate.getText(),
                        mat.getText(), des.getText(), sum.getText(), cat.getText(), size.getText(),
                        authors, interpreters));
                if (ret) {
                    JOptionPane.showMessageDialog(getParent(),
                            "Book has added successfully",
                            "",
                            JOptionPane.PLAIN_MESSAGE);
                    ser.setText("");
                    name.setText("");
                    genre.setText("");
                    lang.setText("");
                    reldate.setText("");
                    mat.setText("");
                    des.setText("");
                    sum.setText("");
                    cat.setText("");
                    size.setText("");
                    authors = new Vector<Integer>();
                    interpreters = new Vector<Integer>();
                }
            }
        });
    }
}
