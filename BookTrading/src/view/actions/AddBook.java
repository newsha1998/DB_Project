package view.actions;

import logic.Portal.Portal;
import logic.object.Book;
import view.basic.Panel;

import javax.swing.*;
import java.awt.*;

public class AddBook extends Panel {
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

    }
}
