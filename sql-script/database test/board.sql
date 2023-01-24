SELECT * FROM alimamadb.board;

-- testing database

INSERT INTO alimamadb.board
(firstName, lastName, phone, email, hashedPassword, title)
values ("chef1", "chef1", "phone1", "email1", "hash1", "manager"),
("chef2", "chef2", "phone2", "email2", "hash2", "accountant"),
("chef3", "chef3", "phone3", "email3", "hash3", "Director");


delete from alimamadb.board;