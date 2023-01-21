CREATE TABLE `reservation`(
    `resid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tid` INT NOT NULL,
    `cid` INT NOT NULL,
    `time` DATETIME NOT NULL,
    `oid` INT NOT NULL,
    `recid` INT NOT NULL
);

CREATE TABLE `delivery`(
    `did` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `oid` INT NOT NULL,
    `cid` INT NOT NULL,
    `dmid` INT NOT NULL,
    `time` DATETIME NOT NULL,
    `address` VARCHAR(45) NOT NULL
);

CREATE TABLE `orders`(
    `oid` INT UNSIGNED NOT NULL,
    `mid` INT UNSIGNED NOT NULL
);

CREATE TABLE `orderDetail`(
    `oid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `cid` INT NOT NULL,
    `wid` INT NOT NULL,
    `tid` INT NULL,
    `totalPrice` DOUBLE(8, 2) NOT NULL,
    `type` VARCHAR(45) NOT NULL DEFAULT '25'
);

CREATE TABLE `menu`(
    `mid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `price` DOUBLE(8, 2) NOT NULL,
    `description` VARCHAR(45) NOT NULL
);

CREATE TABLE `sanitation`(
    `sanid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `shift` VARCHAR(20) NOT NULL DEFAULT '20'
);

CREATE TABLE `security`(
    `sid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `shift` VARCHAR(20) NOT NULL DEFAULT '20'
);

CREATE TABLE `receptionist`(
    `recid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `shift` INT NOT NULL
);

CREATE TABLE `deliveryman`(
    `dmid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `status` VARCHAR(45) NOT NULL DEFAULT '20',
    `shift` VARCHAR(20) NOT NULL DEFAULT '20'
);

CREATE TABLE `waiter`(
    `wid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `shift` VARCHAR(20) NOT NULL DEFAULT '20'
);

CREATE TABLE `chef`(
    `chid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL,
    `shift` VARCHAR(20) NOT NULL DEFAULT '20'
);

CREATE TABLE `customer`(
    `cid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NULL DEFAULT '15',
    `email` VARCHAR(45) NOT NULL,
    `hashedPassword` VARCHAR(255) NOT NULL
);

ALTER TABLE `Branch`
ADD CONSTRAINT `manager_id`
FOREIGN KEY (`manager_id`) REFERENCES `Manager`(`manager_id`)
ON DELETE CASCADE;

ALTER TABLE
    `orderDetail` ADD CONSTRAINT `cid` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`) ON DELETE CASCADE;
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_cid_foreign` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`);
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_cid_foreign` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`);
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_oid_foreign` FOREIGN KEY(`oid`) REFERENCES `orderDetail`(`oid`);
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_oid_foreign` FOREIGN KEY(`oid`) REFERENCES `orderDetail`(`oid`);
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_dmid_foreign` FOREIGN KEY(`dmid`) REFERENCES `deliveryman`(`dmid`);
ALTER TABLE
    `orderDetail` ADD CONSTRAINT `orderdetail_wid_foreign` FOREIGN KEY(`wid`) REFERENCES `waiter`(`wid`);
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_recid_foreign` FOREIGN KEY(`recid`) REFERENCES `receptionist`(`recid`);