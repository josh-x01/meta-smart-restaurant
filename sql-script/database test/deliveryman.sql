SELECT * FROM alimamadb.deliveryman;

-- testing database

INSERT INTO alimamadb.deliveryman
(firstName, lastName, phone, email, hashedPassword, status ,shift)
values ("deliveryman1", "deliveryman1", "phone1", "email1", "hash1", "avaliable", "day"),
("deliveryman2", "deliveryman2", "phone2", "email2", "hash2", "avaliable", "day"),
("deliveryman3", "deliveryman3", "phone3", "email3", "hash3", "avaliable", "day");

