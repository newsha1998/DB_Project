-- Delete System
-- ----------------------------------------------------------

ALTER TABLE InterpreterBook
    DROP CONSTRAINT Bookfk1,
    DROP CONSTRAINT Bookfk2;
ALTER TABLE AuthorBook
    DROP CONSTRAINT Bookfk3,
    DROP CONSTRAINT Bookfk4;
ALTER TABLE Book
    DROP CONSTRAINT Bookfk5;
ALTER TABLE PublisherTelephone
    DROP CONSTRAINT Bookfk6;
ALTER TABLE UserHasBook
    DROP CONSTRAINT Userfk1,
    DROP CONSTRAINT Userfk2;
ALTER TABLE Wallet
    DROP CONSTRAINT Userfk3;
ALTER TABLE Bookstore
    DROP CONSTRAINT Bookstorefk1;
ALTER TABLE BookstoreTelephone
    DROP CONSTRAINT Bookstorefk2;
ALTER TABLE BookstoreHasBook
    DROP CONSTRAINT Bookstorefk3,
    DROP CONSTRAINT Bookstorefk4;
ALTER TABLE BookstoreBankAccount
    DROP CONSTRAINT Bookstorefk5;
ALTER TABLE BookstoreContract
    DROP CONSTRAINT Bookstorefk6,
    DROP CONSTRAINT Bookstorefk7,
    DROP CONSTRAINT Bookstorefk8;
ALTER TABLE EditBookstoreContract
    DROP CONSTRAINT Bookstorefk9,
    DROP CONSTRAINT Bookstorefk10;
ALTER TABLE Comment
    DROP CONSTRAINT Commentfk1;
ALTER TABLE UserCommentForUser
    DROP CONSTRAINT Commentfk2,
    DROP CONSTRAINT Commentfk3;
ALTER TABLE UserCommentForBook
    DROP CONSTRAINT Commentfk4,
    DROP CONSTRAINT Commentfk5;
ALTER TABLE UserCommentForBookstore
    DROP CONSTRAINT Commentfk6,
    DROP CONSTRAINT Commentfk7;
ALTER TABLE Borrow
    DROP CONSTRAINT Borrowfk1,
    DROP CONSTRAINT Borrowfk2,
    DROP CONSTRAINT Borrowfk3;
ALTER TABLE Employee
    DROP CONSTRAINT Employeefk1;
Alter TABLE EmployeeContract
    DROP CONSTRAINT Employeefk2,
    DROP CONSTRAINT Employeefk3,
    DROP CONSTRAINT Employeefk4;
ALTER TABLE Accountant
    DROP CONSTRAINT Employeefk5;
ALTER TABLE SupportAgent
    DROP CONSTRAINT Employeefk6;
ALTER TABLE ExtensionEmployeeContract
    DROP CONSTRAINT Employeefk7,
    DROP CONSTRAINT Employeefk8;
ALTER TABLE CreditChange
    DROP CONSTRAINT Transactionfk1,
    DROP CONSTRAINT Transactionfk2;
ALTER TABLE PaidSalary
		DROP CONSTRAINT Transactionfk3,
	    DROP CONSTRAINT Transactionfk4,
	    DROP CONSTRAINT Transactionfk5;
ALTER TABLE BookstorePony
    DROP CONSTRAINT Transactionfk6,
    DROP CONSTRAINT Transactionfk7;
ALTER TABLE BookstoreMonitoring
    DROP CONSTRAINT Managerfk1,
    DROP CONSTRAINT Managerfk2;
ALTER TABLE UserMonitoring
    DROP CONSTRAINT Managerfk3,
    DROP CONSTRAINT Managerfk4;
ALTER TABLE EmployeeMonitoring
    DROP CONSTRAINT Managerfk5,
    DROP CONSTRAINT Managerfk6;
ALTER TABLE Message
    DROP CONSTRAINT Connectionfk1,
    DROP CONSTRAINT Connectionfk2;
ALTER TABLE Advertisement
    DROP CONSTRAINT Connectionfk3,
    DROP CONSTRAINT Connectionfk4;
ALTER TABLE Complaint
    DROP CONSTRAINT Complaintfk1;
ALTER TABLE ComplaintUser
    DROP CONSTRAINT Complaintfk2,
    DROP CONSTRAINT Complaintfk3,
    DROP CONSTRAINT Complaintfk4;
ALTER TABLE ComplaintBookstore
    DROP CONSTRAINT Complaintfk5,
    DROP CONSTRAINT Complaintfk6,
    DROP CONSTRAINT Complaintfk7;
ALTER TABLE UserBuy
    DROP CONSTRAINT Buyfk1,
    DROP CONSTRAINT Buyfk2,
    DROP CONSTRAINT Buyfk3;
ALTER TABLE UserBuyBookstore
    DROP CONSTRAINT Buyfk4,
    DROP CONSTRAINT Buyfk5,
    DROP CONSTRAINT Buyfk6,
    DROP CONSTRAINT Buyfk7;

DROP TABLE AuthorBook;
DROP TABLE InterpreterBook;
DROP TABLE Book;
DROP TABLE Author;
DROP TABLE Interpreter;
DROP TABLE Publisher;
DROP TABLE PublisherTelephone;
DROP TABLE User;
DROP TABLE UserHasBook;
DROP TABLE Wallet;
DROP TABLE Bookstore;
DROP TABLE BookstoreHasBook;
DROP TABLE BookstoreTelephone;
DROP TABLE BookstoreContract;
DROP TABLE BookstoreBankAccount;
DROP TABLE EditBookstoreContract;
DROP TABLE Comment;
DROP TABLE UserCommentForBook;
DROP TABLE UserCommentForBookstore;
DROP TABLE UserCommentForUser;
DROP TABLE Borrow;
DROP TABLE Employee;
DROP TABLE EmployeeContract;
DROP TABLE ExtensionEmployeeContract;
DROP TABLE Accountant;
DROP TABLE SupportAgent;
DROP TABLE Transaction;
DROP TABLE BookstorePony;
DROP TABLE PaidSalary;
DROP TABLE CreditChange;
DROP TABLE Manager;
DROP TABLE BookstoreMonitoring;
DROP TABLE EmployeeMonitoring;
DROP TABLE UserMonitoring;
DROP TABLE Message;
DROP TABLE Advertisement;
DROP TABLE Complaint;
DROP TABLE ComplaintUser;
DROP TABLE ComplaintBookstore;
DROP TABLE Buy;
DROP TABLE UserBuy;
DROP TABLE UserBuyBookstore;