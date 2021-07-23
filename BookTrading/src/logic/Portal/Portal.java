package logic.Portal;

import logic.object.*;
import logic.sql_instruction.SQLInstruction;

import java.util.Vector;

public abstract class Portal {
    SQLInstruction sqlInstruction;
    boolean access;
    int id;
    String name;

    public Portal(SQLInstruction sqlInstruction) {
        this.sqlInstruction = sqlInstruction;
        access = false;
    }

    public abstract boolean login(String username, String password);

    public int getId() {
        return id;
    }

    public Vector<User> getAllUsers() {
        return sqlInstruction.getExtractor().extractUserTable();
    }

    public User getUserProfileValues(int id) {
        return sqlInstruction.getExtractor().extractUserProfileValues(id);
    }

    public Vector <UserHasBook> getUserBooks (int userId) {
        return sqlInstruction.getExtractor().extractUserBooks(userId);
    }

    public Vector<Author> getAuthors() {
        return sqlInstruction.getExtractor().extractAuthors();
    }

    public Vector<Author> getInterpreters() {
        return sqlInstruction.getExtractor().extractInterpreters();
    }

    public Vector<Publisher> getPublishers() {
        return sqlInstruction.getExtractor().extractPublisher();
    }

    public String getAuthorName (int id) {
        return sqlInstruction.getExtractor().getAuthorName(id);
    }

    public String getInterpreterName (int id) {
        return sqlInstruction.getExtractor().getInterpreterName(id);
    }

    public String getPublisherName (int id) {
        return sqlInstruction.getExtractor().getPublisherName(id);
    }

    public boolean insertBook(Book book) {
        return sqlInstruction.getInsert().insertBook(book);
    }

    public Vector<Message> getUserMessages(int receiverId) {
        return sqlInstruction.getMessageOperation().GetInboxMessages(receiverId);
    }

    public Vector<Book> getAllBooks() {
        return sqlInstruction.getExtractor().extractBookTable();
    }

    public Vector<Book> getAllSimilarBooks(String name) {
        return sqlInstruction.getExtractor().extractSimilarBookTable(name);
    }

    public int AddBorrowReq(int BorrowerId, String LenderUsername, int BookId, double Price, String StartDate,
                            String DeadlineDate, double DailyDelayPenalty,
                            double GuaranteePrice, String DeliveryAddress, String Description){
        return sqlInstruction.getBorrowOperation().AddBorrowReq(BorrowerId, LenderUsername, BookId, Price, StartDate,
                DeadlineDate, DailyDelayPenalty, GuaranteePrice, DeliveryAddress, Description);
    }

    public Book getBookById(int id){
        return sqlInstruction.getExtractor().extractBookById(id);
    }

    public Vector<Borrow> getBorrowRequests(int userId) {
        return sqlInstruction.getBorrowOperation().getBorrowRequests(userId);
    }

    public void ConfirmBorrow(int id){
        sqlInstruction.getBorrowOperation().BorrowConfirmation(id);
    }


    public int getUsetIdByUsername(String username) {
        return sqlInstruction.getExtractor().extractUserIdByUsername(username);
    }

    public void insertCommentForUser(Comment comment) {
        if(comment.getSenderId() != comment.getrId())
            sqlInstruction.getCommentOperation().InsertCommentForUser(comment);
    }
}
