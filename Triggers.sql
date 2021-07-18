USE BookTrading;
CREATE TRIGGER ChangeTrans BEFORE UPDATE ON Transaction FOR EACH ROW
begin
    SIGNAL SQLSTATE '50002' SET MESSAGE_TEXT = 'You Cannot Update Amount';
end;
CREATE TRIGGER DeleteTrans BEFORE DELETE on Transaction FOR EACH ROW
begin
    SIGNAL SQLSTATE '50003' SET MESSAGE_TEXT = 'You Cannot Delete Amount';
end;
CREATE TRIGGER DecreaseLastPaymentDate BEFORE UPDATE ON BookstoreBankAccount FOR EACH ROW
BEGIN
    IF OLD.LastPaymentDate >= NEW.LastPaymentDate THEN
        SIGNAL SQLSTATE '50004' SET MESSAGE_TEXT = 'You Cannot Go to The Past';
    END IF ;
END;
CREATE TRIGGER SuccessfulConversionWithUnsuccessful BEFORE UPDATE ON Buy FOR EACH ROW
    BEGIN
        IF OLD.Success > NEW.Success THEN
            SIGNAL SQLSTATE '50005' SET MESSAGE_TEXT = 'You Cannot Convert Successful Operation to Unsuccessful One';
        end if;
    end;
CREATE TRIGGER ConfirmedConversionWithUnconfirmed BEFORE UPDATE ON Buy FOR EACH ROW
    BEGIN
        IF OLD.Success > NEW.Success THEN
            SIGNAL SQLSTATE '50005' SET MESSAGE_TEXT = 'You Cannot Convert Confirmed Operation to Unconfirmed One';
        end if;
    end;
CREATE TRIGGER PassSecurity1 BEFORE UPDATE ON User FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity2 BEFORE UPDATE ON Bookstore FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity3 BEFORE UPDATE ON Manager FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity4 BEFORE UPDATE ON Employee FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity5 BEFORE INSERT ON User FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity6 BEFORE INSERT ON Bookstore FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity7 BEFORE INSERT ON Manager FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE TRIGGER PassSecurity8 BEFORE INSERT ON Employee FOR EACH ROW
    BEGIN
        IF LENGTH(NEW.Password) < 8 then
            SIGNAL SQLSTATE '50006' SET MESSAGE_TEXT = 'Your Password is too weak';
        end if;
    end;
CREATE VIEW v1 As Select * From Comment Inner JOIN UserCommentForUser ON Comment.Id = UserCommentForUser.CommentId;
CREATE VIEW v2 AS SELECT concat(ReceiverUserId, ReceiverType) as c, AVG(Score) as a from v1 group by concat(ReceiverUserId, ReceiverType);
CREATE TRIGGER updatescore1 AFTER INSERT ON UserCommentForUser FOR EACH ROW
    BEGIN
        if NEW.ReceiverType = "Borrower" then
            UPDATE User join v2 on c = concat(User.Id, "Borrower")
                set ScoreAsBorrower = a;
        end if;
        if NEW.ReceiverType = "Lender" then
            UPDATE User join v2 on c = concat(User.Id, "Lender")
                set ScoreAsLender = a;
        end if;
        if NEW.ReceiverType = "Seller" then
            UPDATE User join v2 on c = concat(User.Id, "Seller")
                set ScoreAsSeller = a;
        end if;
        if NEW.ReceiverType = "Purchaser" then
            UPDATE User join v2 on c = concat(User.Id, "Purchaser")
                set ScoreAsPurchaser = a;
        end if;
    end;
CREATE VIEW v3 As Select * From Comment Inner JOIN UserCommentForBook UCFB on Comment.Id = UCFB.CommentId;
CREATE VIEW v4 AS SELECT BookId as c, AVG(Score) as a from v3 group by BookId;
CREATE TRIGGER updatescore2 AFTER INSERT ON UserCommentForBook FOR EACH ROW
    BEGIN
        UPDATE Book join v4 on c = Book.Id
            set Score = a;
    end;
CREATE VIEW v5 As Select * From Comment Inner JOIN UserCommentForBookstore UCFB on Comment.Id = UCFB.CommentId;
CREATE VIEW v6 AS SELECT BookstoreId as c, AVG(Score) as a from v5 group by BookstoreId;
CREATE TRIGGER updatescore3 AFTER INSERT ON UserCommentForBookstore FOR EACH ROW
    BEGIN
        UPDATE Bookstore join v6 on c = Bookstore.Id
            set Bookstore.Score = a;
    end;
