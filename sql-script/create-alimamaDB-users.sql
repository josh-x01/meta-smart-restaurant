CREATE USER IF NOT EXISTS 'owner'@'localhost' IDENTIFIED BY 'owner';
CREATE USER IF NOT EXISTS 'alimamaCustomer'@'localhost' IDENTIFIED BY 'alimamaCustomer';
CREATE USER IF NOT EXISTS 'alimamaChef'@'localhost' IDENTIFIED BY 'alimamaChef';
CREATE USER IF NOT EXISTS 'alimamaWaiter'@'localhost' IDENTIFIED BY 'alimamaWaiter';
CREATE USER IF NOT EXISTS 'alimamaDeliveryman'@'localhost' IDENTIFIED BY 'alimamaDeliveryman';
CREATE USER IF NOT EXISTS 'alimamaReceptionist'@'localhost' IDENTIFIED BY 'alimamaReceptionist';
CREATE USER IF NOT EXISTS 'alimamaSecurity'@'localhost' IDENTIFIED BY 'alimamaSecurity';
CREATE USER IF NOT EXISTS 'alimamaSanitation'@'localhost' IDENTIFIED BY 'alimamaSanitation';

GRANT ALL PRIVILEGES ON alimamadb TO 'alimama'@'localhost';
