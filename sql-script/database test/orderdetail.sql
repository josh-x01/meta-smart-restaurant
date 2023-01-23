SELECT * FROM alimamadb.orderdetail;

-- test database

INSERT INTO alimamadb.orderdetail 
(cid, wid, tid, totalPrice, type)
values (3, 3, 1, 1000.02, "delivery");

DELETE FROM alimamadb.orderdetail where oid=5;