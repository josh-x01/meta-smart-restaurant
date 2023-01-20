CREATE USER IF NOT EXISTS 'metaCustomer'@'localhost' IDENTIFIED BY 'metaCustomer';

GRANT ALL PRIVILEGES ON meta.customer TO 'metaCustomer'@'localhost';
