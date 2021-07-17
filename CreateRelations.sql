USE BookTrading;

CREATE TABLE Book (
    ID int primary key auto_increment,
    PublisherID int,
    Name varchar(50),
    Score DOUBLE,
    Price DOUBLE,
    Genre varchar(20),
    Language varchar(20),
    ReleaseDate DATE,
    Material varchar(20),
    SeriesNumber varchar(20),
    Description varchar(500),
    Summary varchar(500),
    Category varchar(20),
    Size varchar(20),
    check (0 <= Score AND Score <= 10)
);
CREATE TABLE Author (
    ID int primary key AUTO_INCREMENT,
    FirstName varchar(50),
    Surname varchar(50),
    Nationality varchar(20),
    BirthDate date,
    DeathDate date,
    WritingStyle varchar(20),
    Doctrine varchar(20),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20),
    Description varchar(500)
);
CREATE TABLE AuthorBook (
    AuthorId int,
    BookId int,
    PRIMARY KEY (AuthorId, BookId)
);
CREATE TABLE Interpreter (
    ID int primary key auto_increment,
    FirstName varchar(50),
    Surname varchar(50),
    Nationality varchar(20),
    BirthDate date,
    DeathDate date,
    Style varchar(20),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20),
    Description varchar(500)
);
CREATE TABLE InterpreterBook (
    InterpreterId int,
    BookId int,
    Language varchar(20),
    PRIMARY KEY (InterpreterId, BookId)
);
CREATE TABLE Publisher (
    RegistrationNumber int primary key auto_increment,
    Name varchar(50),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20)
);
CREATE TABLE PublisherTelephone (
    RegistrationNumber int,
    Telephone varchar(20)
);
Create Table Bookstore (
    Id int primary key auto_increment,
    BookstoreContractId int,
    Password varchar(50),
    Name varchar(50),
    Email varchar(50),
    RegistrationNumber int unique ,
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    BuildingNumber varchar(20),
    CreditCardNumber varchar(20),
    Website varchar(20),
    Score double,
    check ( Score >= 0 AND Score <= 10)
);
Create Table BookstoreTelephone (
    BookstoreId int,
    Telephone varchar(20)
);
Create Table BookstoreHasBook (
    BookstoreId int,
    BookId int,
    Number int,
    Price double,
    PRIMARY KEY (BookstoreId, BookId)
);
CREATE TABLE BookstoreContract (
    Id int primary key auto_increment,
    ContractorId int,
    CancellerId int,
    BookStoreId int,
    Date date,
    SystemProfitpercentage double,
    Description varchar(500)
);
create table BookstoreBankAccount (
    BookstoreId int primary key,
    TotalIncome double,
    SystemTotalBenefit double,
    BookstoreCreditCardNumber varchar(20),
    RemainingBalance double,
    LastPaymentDate Date
);
create table EditBookstoreContract (
    ContractId int,
    SupporterId int,
    Date Date,
    Description varchar(500),
    primary key (ContractId, SupporterId, Date)
);
CREATE TABLE Comment (
    Id int primary key auto_increment,
    SenderUserId int,
    Score DOUBLE,
    Subject varchar(50),
    Text varchar(500),
    Date DATE,
    Time TIME,
    check ( Score >= 0 AND Score <= 10)
);
CREATE TABLE UserCommentForUser (
    CommentId int,
    ReceiverUserId int,
    ReceiverType varchar(20),
    check ( ReceiverType = "Borrower" OR ReceiverType = "Lender" OR
            ReceiverType = "Seller" OR ReceiverType = "Purchaser")
);
CREATE TABLE UserCommentForBook (
    CommentId int,
    BookId int
);
CREATE TABLE UserCommentForBookstore (
    CommentId int,
    BookstoreId int
);
CREATE TABLE Complaint (
    Id int primary key auto_increment,
    SupportAgentId int,
    Date date,
    Time time,
    Subject varchar(50),
    Text varchar(500),
    Documentation varchar(500),
    Status BOOLEAN,
    Result varchar(100)
);
CREATE TABLE ComplaintUser(
    ComplaintId int primary key ,
    PlaintiffId int,
    UserId int
);
CREATE TABLE ComplaintBookstore (
    ComplaintId int primary key ,
    PlaintiffId int,
    BookstoreId int
);
CREATE TABLE Message (
    Id int primary key auto_increment,
    ReceiverUserId int,
    SenderUserId int,
    Subject varchar(50),
    Text varchar(500),
    Date date default (current_date),
    Time time default (current_time)
);
CREATE TABLE Advertisement (
    Id int primary key auto_increment,
    BookId int,
    UserId int,
    Title varchar(50),
    ProposedPrice double,
    Description varchar(500)
);
create table Buy (
    Id int primary key auto_increment,
    Date Date,
    BookPrice double,
    Success boolean,
    Description varchar(500)
);
create table UserBuy (
    Id int primary key,
    BuyerId int,
    SellerId int,
    BookId int,
    DeliveryAddress varchar(500)
);
create table UserBuyBookstore (
    Id int primary key,
    UserId int,
    BookStoreId int,
    BookId int,
    SendingAddress varchar(500)
);
create table Borrow (
    Id int primary key auto_increment,
    BorrowerId int,
    LenderId int,
    BookId int,
    Status varchar(20),
    Price double,
    StartDate Date,
    DeadlineDate Date,
    DailyDelayPenalty double,
    GuaranteePrice double,
    Confirmation BOOLEAN,
    DeliveryAddress varchar(500),
    Description varchar(500),
    check ( Status = "Borrowed" OR Status = "Cancelled" OR  Status = "Returned"
        OR Status = "InDelay" OR Status = "GetGuaranteePrice")
);
CREATE TABLE Manager (
    Id int primary key auto_increment,
    NationalId int unique ,
    FirstName varchar(50),
    Surname varchar(50),
    Email varchar(50),
    Password varchar(50),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20)
);
CREATE TABLE BookstoreMonitoring (
    ManagerId int,
    BookstoreId int,
    Date date,
    Description varchar(500),
    primary key (ManagerId, BookstoreId, Date)
);
CREATE TABLE UserMonitoring (
    ManagerId int,
    UserId int,
    Date date,
    Description varchar(500),
    primary key (ManagerId, UserId, Date)
);
CREATE TABLE EmployeeMonitoring (
    ManagerId int,
    EmployeeId int,
    Date date,
    Description varchar(500),
    primary key (ManagerId, EmployeeId, Date)
);
CREATE TABLE Employee (
    Id int primary key auto_increment,
    EmployeeContractId int,
    NationalId int unique ,
    FirstName varchar(50),
    Surname varchar(50),
    Email varchar(50),
    Password varchar(50),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20),
    CreditCardNumber varchar(20)
);
CREATE TABLE EmployeeContract (
    Id int primary key auto_increment,
    EmployeeId int,
    ContractorId int,
    CancellerId int,
    Date date,
    DailySalary double,
    Description varchar(500)
);
CREATE TABLE Accountant (
    EmployeeId int primary key
);
CREATE TABLE SupportAgent (
    EmployeeId int primary key
);
CREATE TABLE ExtensionEmployeeContract (
    ContractId int,
    ManagerId int,
    Date date,
    Description varchar(500),
    primary key (ContractId, ManagerId, Date)
);
create table Transaction (
    Id int primary key auto_increment,
    Type varchar(20),
    Amount double,
    CreditCardNumber varchar(20),
    Date Date,
    Time Time,
    Status boolean,
    Description varchar(500),
    check (Type = "IncreaseAmanat" OR Type = "WithdrawAmanat"
		OR Type = "IncreaseIncome" OR Type = "IncreaseExpenditures")
);
create table CreditChange (
    Id int primary key auto_increment,
    WalletUserId int,
    TransactionId int
);
create table PaidSalary (
    Id int primary key auto_increment,
    TransactionId int,
    AccountantId int,
    EmployeeId int
);
create table BookstorePony (
    Id int primary key auto_increment,
    BookstoreBankAccountId int,
    TransactionId int
);
Create Table User (
    Id int primary key auto_increment,
    NationalId int,
    FirstName varchar(50) NOT NULL,
    Surname varchar(50) NOT NULL,
    Email varchar(50),
    Password varchar(50),
    CreditCardNumber varchar(20),
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20),
    ScoreAsSeller double,
    ScoreAsLender double,
    ScoreAsBorrower double,
    ScoreAsPurchaser double,
    CHECK (0 <= ScoreAsSeller AND ScoreAsSeller <= 10),
    CHECK (0 <= ScoreAsLender AND ScoreAsLender <= 10),
    CHECK (0 <= ScoreAsBorrower AND ScoreAsBorrower <= 10),
    CHECK (0 <= ScoreAsPurchaser AND ScoreAsPurchaser <= 10)
);
Create table UserHasBook (
    UserId int,
    BookId int,
    Number int,
    Status varchar(20),
    Primary Key (UserId, BookId)
);
Create Table Wallet (
    UserId int primary key ,
    BlockedCredit DOUBLE,
    AvailableCredit DOUBLE
);
