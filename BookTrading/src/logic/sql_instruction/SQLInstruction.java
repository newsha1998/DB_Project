package logic.sql_instruction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLInstruction {
    Connection connection;
    Extractor extractor;
    Login login;
    Register register;
    Exists exists;
    Update update;
    MessageOperation messageOperation;
    Insert insert;
    CommentOperation commentOperation;

    public SQLInstruction() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/BookTrading?"
                            + "user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        extractor = new Extractor(connection);
        login = new Login(connection);
        register = new Register(connection);
        exists = new Exists(connection);
        update = new Update(connection);
        messageOperation = new MessageOperation(connection);
        insert = new Insert(connection);
        commentOperation = new CommentOperation(connection);
    }

    public Extractor getExtractor() {
        return extractor;
    }

    public Login getLogin() {
        return login;
    }

    public Register getRegister() {
        return register;
    }

    public Exists getExists() {
        return exists;
    }

    public Update getUpdate() {
        return update;
    }

    public MessageOperation getMessageOperation() {
        return messageOperation;
    }

    public Insert getInsert() {
        return insert;
    }

    public CommentOperation getCommentOperation() {
        return commentOperation;
    }
}
