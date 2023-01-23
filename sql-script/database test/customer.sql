SELECT * FROM alimamadb.customer;

-- testing database

INSERT INTO alimamadb.customer
(firstName, lastName, phone, email, hashedPassword)
values ("customer1", "customer1", "phone1", "email1", "hash1"),
("customer2", "customer2", "phone2", "email2", "hash2"),
("customer3", "customer3", "phone3", "email3", "hash3");


DELETE FROM alimamadb.customer where cid=1;