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
