USE BookTrading;

CREATE TABLE Book (
    ID int primary key auto_increment,
    PublisherID int,
    Name varchar(50) not null ,
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
    AuthorId int not null ,
    BookId int not null ,
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
    InterpreterId int not null ,
    BookId int not null ,
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
    RegistrationNumber int not null ,
    Telephone varchar(20) not null
);
Create Table Bookstore (
    Id int primary key auto_increment,
    BookstoreContractId int,
    Password varchar(50) not null ,
    Name varchar(50) not null ,
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
    BookstoreId int not null ,
    Telephone varchar(20) not null
);
Create Table BookstoreHasBook (
    BookstoreId int not null ,
    BookId int not null ,
    Number int default (1),
    Price double,
    PRIMARY KEY (BookstoreId, BookId)
);
CREATE TABLE BookstoreContract (
    Id int primary key auto_increment,
    ContractorId int not null ,
    CancellerId int,
    BookStoreId int,
    Date date,
    SystemProfitpercentage double default (20) not null ,
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
    ContractId int not null ,
    SupporterId int not null ,
    Date Date not null ,
    Description varchar(500),
    primary key (ContractId, SupporterId, Date)
);
CREATE TABLE Comment (
    Id int primary key auto_increment,
    SenderUserId int not null ,
    Score DOUBLE default (5) not null ,
    Subject varchar(50),
    Text varchar(500),
    Date DATE default (current_date),
    Time TIME default (current_time),
    check ( Score >= 0 AND Score <= 10)
);
CREATE TABLE UserCommentForUser (
    CommentId int primary key not null ,
    ReceiverUserId int not null ,
    ReceiverType varchar(20) not null ,
    check ( ReceiverType = "Borrower" OR ReceiverType = "Lender" OR
            ReceiverType = "Seller" OR ReceiverType = "Purchaser")
);
CREATE TABLE UserCommentForBook (
    CommentId int primary key not null ,
    BookId int not null
);
CREATE TABLE UserCommentForBookstore (
    CommentId int primary key not null ,
    BookstoreId int not null
);
CREATE TABLE Complaint (
    Id int primary key auto_increment,
    SupportAgentId int,
    Date date default (current_date),
    Time time default (current_time),
    Subject varchar(50),
    Text varchar(500),
    Documentation varchar(500),
    Status BOOLEAN,
    Result varchar(100)
);
CREATE TABLE ComplaintUser(
    ComplaintId int primary key ,
    PlaintiffId int not null ,
    UserId int not null
);
CREATE TABLE ComplaintBookstore (
    ComplaintId int primary key ,
    PlaintiffId int not null ,
    BookstoreId int not null
);
CREATE TABLE Message (
    Id int primary key auto_increment,
    ReceiverUserId int not null ,
    SenderUserId int not null ,
    Subject varchar(50),
    Text varchar(500),
    Date date default (current_date),
    Time time default (current_time)
);
CREATE TABLE Advertisement (
    Id int primary key auto_increment,
    BookId int not null ,
    UserId int not null ,
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
    BuyerId int not null ,
    SellerId int not null ,
    BookId int not null ,
    DeliveryAddress varchar(500)
);
create table UserBuyBookstore (
    Id int primary key,
    UserId int not null ,
    BookStoreId int not null ,
    BookId int not null ,
    SendingAddress varchar(500)
);
create table Borrow (
    Id int primary key auto_increment,
    BorrowerId int not null ,
    LenderId int not null ,
    BookId int not null ,
    Status varchar(20),
    Price double,
    StartDate Date not null ,
    DeadlineDate Date not null ,
    DailyDelayPenalty double not null ,
    GuaranteePrice double not null ,
    Confirmation BOOLEAN default (false) not null ,
    DeliveryAddress varchar(500),
    Description varchar(500),
    check ( Status = "Borrowed" OR Status = "Cancelled" OR  Status = "Returned"
        OR Status = "InDelay" OR Status = "GetGuaranteePrice")
);
CREATE TABLE Manager (
    Id int primary key auto_increment,
    NationalId int unique ,
    FirstName varchar(50) not null ,
    Surname varchar(50) not null ,
    Email varchar(50),
    Password varchar(50) not null ,
    City varchar(20),
    Region varchar(20),
    Street varchar(20),
    Alley varchar(20),
    HouseNumber varchar(20),
    Telephone varchar(20)
);
CREATE TABLE BookstoreMonitoring (
    ManagerId int not null ,
    BookstoreId int not null ,
    Date date not null ,
    Description varchar(500),
    primary key (ManagerId, BookstoreId, Date)
);
CREATE TABLE UserMonitoring (
    ManagerId int not null ,
    UserId int not null ,
    Date date not null ,
    Description varchar(500),
    primary key (ManagerId, UserId, Date)
);
CREATE TABLE EmployeeMonitoring (
    ManagerId int not null ,
    EmployeeId int not null ,
    Date date not null ,
    Description varchar(500),
    primary key (ManagerId, EmployeeId, Date)
);
CREATE TABLE Employee (
    Id int primary key auto_increment,
    EmployeeContractId int,
    NationalId int unique ,
    FirstName varchar(50) not null ,
    Surname varchar(50) not null ,
    Email varchar(50),
    Password varchar(50) not null ,
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
    ContractorId int not null ,
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
    ContractId int not null ,
    ManagerId int not null ,
    Date date not null ,
    Description varchar(500),
    primary key (ContractId, ManagerId, Date)
);
create table Transaction (
    Id int primary key auto_increment,
    Type varchar(20),
    Amount double not null ,
    CreditCardNumber varchar(20),
    Date Date default (CURRENT_DATE),
    Time Time default (current_time),
    Status boolean,
    Description varchar(500),
    check (Type = "IncreaseAmanat" OR Type = "WithdrawAmanat"
		OR Type = "IncreaseIncome" OR Type = "IncreaseExpenditures"),
	check ( Amount <= 5000 )
);
create table CreditChange (
    Id int primary key auto_increment,
    WalletUserId int not null ,
    TransactionId int not null
);
create table PaidSalary (
    Id int primary key auto_increment,
    TransactionId int not null ,
    AccountantId int not null ,
    EmployeeId int not null
);
create table BookstorePony (
    Id int primary key auto_increment,
    BookstoreBankAccountId int not null ,
    TransactionId int not null
);
Create Table User (
    Id int primary key auto_increment,
    NationalId int,
    FirstName varchar(50) NOT NULL,
    Surname varchar(50) NOT NULL,
    Email varchar(50),
    Password varchar(50) not null ,
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
