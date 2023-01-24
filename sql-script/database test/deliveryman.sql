SELECT * FROM alimamadb.deliveryman;

-- testing database

INSERT INTO alimamadb.deliveryman
(firstName, lastName, phone, email, hashedPassword ,shift, status)
values ("deliveryman1", "deliveryman1", "phone1", "email1", "hash1", "day", "avaliable"),
("deliveryman2", "deliveryman2", "phone2", "email2", "hash2", "day", "avaliable"),
("deliveryman3", "deliveryman3", "phone3", "email3", "hash3", "day", "avaliable");

