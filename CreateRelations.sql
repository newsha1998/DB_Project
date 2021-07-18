USE BookTrading;

ALTER TABLE InterpreterBook
    ADD CONSTRAINT Bookfk1
    FOREIGN KEY (InterpreterId) REFERENCES Interpreter(ID),
    ADD CONSTRAINT Bookfk2
    FOREIGN KEY (BookId) REFERENCES Book(ID);
ALTER TABLE AuthorBook
    ADD CONSTRAINT Bookfk3
    FOREIGN KEY (AuthorId) REFERENCES Author(ID),
    ADD CONSTRAINT Bookfk4
    FOREIGN KEY (BookId) REFERENCES Book(ID);
ALTER TABLE Book
    ADD CONSTRAINT Bookfk5
    FOREIGN KEY (PublisherID) REFERENCES Publisher(RegistrationNumber);
ALTER TABLE PublisherTelephone
    ADD CONSTRAINT Bookfk6
    FOREIGN KEY (RegistrationNumber) REFERENCES Publisher(RegistrationNumber);
ALTER TABLE Bookstore
    ADD CONSTRAINT Bookstorefk1
    FOREIGN KEY (BookstoreContractId) REFERENCES BookstoreContract(Id);
ALTER TABLE BookstoreTelephone
    ADD CONSTRAINT Bookstorefk2
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id);
ALTER TABLE BookstoreHasBook
    ADD CONSTRAINT Bookstorefk3
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id),
    ADD CONSTRAINT Bookstorefk4
    FOREIGN KEY (BookId) REFERENCES Book(Id);
ALTER TABLE BookstoreBankAccount
    ADD CONSTRAINT Bookstorefk5
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id);
ALTER TABLE BookstoreContract
    ADD CONSTRAINT Bookstorefk6
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id),
    ADD CONSTRAINT Bookstorefk7
    FOREIGN KEY (CancellerId) REFERENCES SupportAgent(EmployeeId),
     ADD CONSTRAINT Bookstorefk8
    FOREIGN KEY (ContractorId) REFERENCES SupportAgent(EmployeeId);
ALTER TABLE EditBookstoreContract
    ADD CONSTRAINT Bookstorefk9
    FOREIGN KEY (ContractId) REFERENCES BookstoreContract(Id),
    ADD CONSTRAINT Bookstorefk10
    FOREIGN KEY (SupporterId) REFERENCES SupportAgent(EmployeeId);
ALTER TABLE Comment
    ADD CONSTRAINT Commentfk1
    FOREIGN KEY (SenderUserId) REFERENCES User(Id);
ALTER TABLE UserCommentForUser
    ADD CONSTRAINT Commentfk2
    FOREIGN KEY (CommentId) REFERENCES Comment(Id),
    ADD CONSTRAINT Commentfk3
    FOREIGN KEY (ReceiverUserId) REFERENCES User(Id);
ALTER TABLE UserCommentForBook
    ADD CONSTRAINT Commentfk4
    FOREIGN KEY (CommentId) REFERENCES Comment(Id),
    ADD CONSTRAINT Commentfk5
    FOREIGN KEY (BookId) REFERENCES Book(Id);
ALTER TABLE UserCommentForBookstore
    ADD CONSTRAINT Commentfk6
    FOREIGN KEY (CommentId) REFERENCES Comment(Id),
    ADD CONSTRAINT Commentfk7
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id);
ALTER TABLE Complaint
    ADD CONSTRAINT Complaintfk1
    FOREIGN KEY (SupportAgentId) REFERENCES SupportAgent(EmployeeId);
ALTER TABLE ComplaintUser
    ADD CONSTRAINT Complaintfk2
    FOREIGN KEY (ComplaintId) REFERENCES Complaint(Id),
    ADD CONSTRAINT Complaintfk3
    FOREIGN KEY (PlaintiffId) REFERENCES User(Id),
    ADD CONSTRAINT Complaintfk4
    FOREIGN KEY (UserId) REFERENCES User(Id);
ALTER TABLE ComplaintBookstore
    ADD CONSTRAINT Complaintfk5
    FOREIGN KEY (ComplaintId) REFERENCES Complaint(Id),
    ADD CONSTRAINT Complaintfk6
    FOREIGN KEY (PlaintiffId) REFERENCES User(Id),
    ADD CONSTRAINT Complaintfk7
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id);
ALTER TABLE Message
    ADD CONSTRAINT Connectionfk1
    FOREIGN KEY (ReceiverUserId) REFERENCES User(Id),
    ADD CONSTRAINT Connectionfk2
    FOREIGN KEY (SenderUserId) REFERENCES User(Id);
ALTER TABLE Advertisement
    ADD CONSTRAINT Connectionfk3
    FOREIGN KEY (BookId) REFERENCES Book(ID),
    ADD CONSTRAINT Connectionfk4
    FOREIGN KEY (UserId) REFERENCES User(Id);
ALTER TABLE UserBuy
    ADD CONSTRAINT Buyfk1
    FOREIGN KEY (Id) REFERENCES Buy(Id),
    ADD CONSTRAINT Buyfk2
    FOREIGN KEY (BuyerId) REFERENCES User(Id),
	ADD CONSTRAINT Buyfk3
    FOREIGN KEY (SellerId) REFERENCES User(Id);
ALTER TABLE UserBuyBookstore
    ADD CONSTRAINT Buyfk4
    FOREIGN KEY (Id) REFERENCES Buy(Id),
    ADD CONSTRAINT Buyfk5
    FOREIGN KEY (UserId) REFERENCES User(Id),
	ADD CONSTRAINT Buyfk6
    FOREIGN KEY (BookStoreId) REFERENCES Bookstore(Id),
    ADD CONSTRAINT Buyfk7
    FOREIGN KEY (BookId) REFERENCES Book(Id);
ALTER TABLE Borrow
    ADD CONSTRAINT Borrowfk1
    FOREIGN KEY (BorrowerId) REFERENCES User(Id),
    ADD CONSTRAINT Borrowfk2
    FOREIGN KEY (LenderId) REFERENCES User(Id),
    ADD CONSTRAINT Borrowfk3
    FOREIGN KEY (BookId) REFERENCES Book(Id);
ALTER TABLE BookstoreMonitoring
    ADD CONSTRAINT Managerfk1
    FOREIGN KEY (ManagerId) REFERENCES Manager(Id),
    ADD CONSTRAINT Managerfk2
    FOREIGN KEY (BookstoreId) REFERENCES Bookstore(Id);
ALTER TABLE UserMonitoring
    ADD CONSTRAINT Managerfk3
    FOREIGN KEY (ManagerId) REFERENCES Manager(Id),
    ADD CONSTRAINT Managerfk4
    FOREIGN KEY (UserId) REFERENCES User(Id);
ALTER TABLE EmployeeMonitoring
    ADD CONSTRAINT Managerfk5
    FOREIGN KEY (ManagerId) REFERENCES Manager(Id),
    ADD CONSTRAINT Managerfk6
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id);
ALTER TABLE Employee
    ADD CONSTRAINT Employeefk1
    FOREIGN KEY (EmployeeContractId) REFERENCES EmployeeContract(Id);
Alter TABLE EmployeeContract
    ADD CONSTRAINT Employeefk2
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id),
    ADD CONSTRAINT Employeefk3
    FOREIGN KEY (ContractorId) REFERENCES Manager(Id),
        ADD CONSTRAINT Employeefk4
    FOREIGN KEY (CancellerId) REFERENCES Manager(Id);
ALTER TABLE Accountant
    ADD CONSTRAINT Employeefk5
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id);
ALTER TABLE SupportAgent
    ADD CONSTRAINT Employeefk6
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id);
ALTER TABLE ExtensionEmployeeContract
    ADD CONSTRAINT Employeefk7
    FOREIGN KEY (ContractId) REFERENCES EmployeeContract(Id),
    ADD CONSTRAINT Employeefk8
    FOREIGN KEY (ManagerId) REFERENCES Manager(Id);
ALTER TABLE CreditChange
    ADD CONSTRAINT Transactionfk1
    FOREIGN KEY (WalletUserId) REFERENCES Wallet(UserId),
    ADD CONSTRAINT Transactionfk2
    FOREIGN KEY (TransactionId) REFERENCES Transaction(Id);
ALTER TABLE PaidSalary
    ADD CONSTRAINT Transactionfk3
    FOREIGN KEY (AccountantId) REFERENCES Accountant(EmployeeId),
    ADD CONSTRAINT Transactionfk4
    FOREIGN KEY (TransactionId) REFERENCES Transaction(Id),
    ADD CONSTRAINT Transactionfk5
    FOREIGN KEY (EmployeeId) REFERENCES Employee(Id);
ALTER TABLE BookstorePony
    ADD CONSTRAINT Transactionfk6
    FOREIGN KEY (BookstoreBankAccountId) REFERENCES BookstoreBankAccount(BookstoreId),
    ADD CONSTRAINT Transactionfk7
    FOREIGN KEY (TransactionId) REFERENCES Transaction(Id);
ALTER TABLE UserHasBook
    ADD CONSTRAINT Userfk1
    FOREIGN KEY (UserId) REFERENCES User(Id),
    ADD CONSTRAINT Userfk2
    FOREIGN KEY (BookId) REFERENCES Book(Id);
ALTER TABLE Wallet
    ADD CONSTRAINT Userfk3
    FOREIGN KEY (UserId) REFERENCES User(Id);
