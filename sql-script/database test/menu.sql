SELECT * FROM alimamadb.menu;

-- testing database

INSERT INTO alimamadb.menu
(name, category, price, description)
values("menu1", "category1", 1.01, "description1"),
("menu2", "category2", 2.02, "description2"),
("menu3", "category3", 3.03, "description3");

DELETE FROM alimamadb.menu WHERE mid = 2;