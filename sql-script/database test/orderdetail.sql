SELECT * FROM alimamadb.orderdetail;

-- test database

INSERT INTO alimamadb.orderdetail 
(cid, wid, totalPrice, type)
values (2, 2, 1000.02, "delivery");

DELETE FROM alimamadb.orderdetail where oid=6;