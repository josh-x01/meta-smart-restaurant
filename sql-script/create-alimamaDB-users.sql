USE alimamadb;

CREATE USER IF NOT EXISTS 'alimama'@'localhost' IDENTIFIED BY 'alimama';
CREATE USER IF NOT EXISTS 'owner'@'localhost' IDENTIFIED BY 'owner';
CREATE USER IF NOT EXISTS 'alimamaCustomer'@'localhost' IDENTIFIED BY 'alimamaCustomer';
CREATE USER IF NOT EXISTS 'alimamaChef'@'localhost' IDENTIFIED BY 'alimamaChef';
CREATE USER IF NOT EXISTS 'alimamaWaiter'@'localhost' IDENTIFIED BY 'alimamaWaiter';
CREATE USER IF NOT EXISTS 'alimamaDeliveryman'@'localhost' IDENTIFIED BY 'alimamaDeliveryman';
CREATE USER IF NOT EXISTS 'alimamaReceptionist'@'localhost' IDENTIFIED BY 'alimamaReceptionist';
CREATE USER IF NOT EXISTS 'alimamaSecurity'@'localhost' IDENTIFIED BY 'alimamaSecurity';
CREATE USER IF NOT EXISTS 'alimamaSanitation'@'localhost' IDENTIFIED BY 'alimamaSanitation';

GRANT ALL PRIVILEGES ON alimamadb.* TO 'alimama'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.* TO 'owner'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.customer TO 'alimamaCustomer'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.chef TO 'alimamaChef'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.waiter TO 'alimamaWaiter'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.deliveryman TO 'alimamaDeliveryman'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.receptionist TO 'alimamaReceptionist'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.security TO 'alimamaSecurity'@'localhost';
GRANT ALL PRIVILEGES ON alimamadb.sanitation TO 'alimamaSanitation'@'localhost';

-- DROP USER IF EXISTS 'alimama'@'localhost';
-- DROP USER IF EXISTS 'alimamaCustomer'@'localhost';
-- DROP USER IF EXISTS 'alimamaChef'@'localhost';
-- DROP USER IF EXISTS 'alimamaWaiter'@'localhost';
-- DROP USER IF EXISTS 'alimamaDeliveryman'@'localhost';
-- DROP USER IF EXISTS 'alimamaReceptionist'@'localhost';
-- DROP USER IF EXISTS 'alimamaSecurity'@'localhost';
-- DROP USER IF EXISTS 'alimamaSanitation'@'localhost';