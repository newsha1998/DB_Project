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

ALTER TABLE UserHasBook
    ADD CONSTRAINT Userfk1
    FOREIGN KEY (UserId) REFERENCES User(Id),
    ADD CONSTRAINT Userfk2
    FOREIGN KEY (BookId) REFERENCES Book(Id);
