-- Remake System
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

DROP TABLE AuthorBook;
DROP TABLE InterpreterBook;
DROP TABLE Book;
DROP TABLE Author;
DROP TABLE Interpreter;
DROP TABLE Publisher;
DROP TABLE PublisherTelephone;
-- ----------------------------------------------------------

ALTER TABLE UserHasBook
    DROP CONSTRAINT Userfk1,
    DROP CONSTRAINT Userfk2;

DROP TABLE User;
DROP TABLE UserHasBook;
-- ----------------------------------------------------------

ALTER TABLE Bookstore
    DROP CONSTRAINT Bookstorefk1;
ALTER TABLE BookstoreTelephone
    DROP CONSTRAINT Bookstorefk2;
ALTER TABLE BookstoreHasBook
    DROP CONSTRAINT Bookstorefk3,
    DROP CONSTRAINT Bookstorefk4;

DROP TABLE Bookstore;
DROP TABLE BookstoreHasBook;
DROP TABLE BookstoreTelephone;
DROP TABLE BookstoreContract;
-- ----------------------------------------------------------
