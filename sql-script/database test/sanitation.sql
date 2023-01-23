SELECT * FROM alimamadb.sanitation;

-- testing database

INSERT INTO alimamadb.sanitation
(firstName, lastName, phone, email, hashedPassword, shift)
values ("sanitation1", "sanitation1", "phone1", "email1", "hash1", "day"),
("sanitation2", "sanitation2", "phone2", "email2", "hash2", "day"),
("sanitation3", "sanitation3", "phone3", "email3", "hash3", "day");