SELECT * FROM alimamadb.waiter;

-- testing database

INSERT INTO alimamadb.waiter
(firstName, lastName, phone, email, hashedPassword, shift, status)
values ("waiter1", "waiter1", "phone1", "email1", "hash1", "day", "available"),
("waiter2", "waiter2", "phone2", "email2", "hash2", "day", "available"),
("waiter3", "waiter3", "phone3", "email3", "hash3", "day", "available");

DELETE FROM alimamadb.waiter where wid=2;