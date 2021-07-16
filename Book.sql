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
