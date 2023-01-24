USE alimamadb;

CREATE TABLE `reservation`(
    `resid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tid` INT UNSIGNED NOT NULL,
    `cid` INT UNSIGNED NOT NULL,
    `oid` INT UNSIGNED NOT NULL,
    `recid` INT UNSIGNED NOT NULL,
	`time` DATETIME NOT NULL
);

CREATE TABLE `delivery`(
    `did` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `oid` INT UNSIGNED NOT NULL,
    `cid` INT UNSIGNED NOT NULL,
    `dmid` INT UNSIGNED NOT NULL,
    `address` VARCHAR(45) NOT NULL,
	`time` DATETIME NOT NULL
);

CREATE TABLE `orders`(
    `oid` INT UNSIGNED NOT NULL,
    `mid` INT UNSIGNED NOT NULL
);

CREATE TABLE `orderDetail`(
    `oid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `cid` INT UNSIGNED NOT NULL,
    `wid` INT UNSIGNED NOT NULL,
    `tid` INT NULL,
    `totalPrice` DOUBLE(8, 2) NOT NULL,
    `type` VARCHAR(45) NOT NULL,
    `time` DATETIME NOT NULL
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
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `security`(
    `sid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `receptionist`(
    `recid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `deliveryman`(
    `dmid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `waiter`(
    `wid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `chef`(
    `chid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
    `shift` VARCHAR(20) NOT NULL,
	`status` VARCHAR(100) NOT NULL
);

CREATE TABLE `customer`(
    `cid` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `phone` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `hashedPassword` VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE `alimamadb`.`board` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL UNIQUE,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `hashedPassword` VARCHAR(255) NOT NULL UNIQUE,
  `title` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

ALTER TABLE
    `orderDetail` ADD CONSTRAINT `cid` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`) ON DELETE CASCADE;
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_cid_foreign` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`) ON DELETE CASCADE;
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_cid_foreign` FOREIGN KEY(`cid`) REFERENCES `customer`(`cid`)  ON DELETE CASCADE;
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_oid_foreign` FOREIGN KEY(`oid`) REFERENCES `orderDetail`(`oid`) ON DELETE CASCADE;
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_oid_foreign` FOREIGN KEY(`oid`) REFERENCES `orderDetail`(`oid`) ON DELETE CASCADE;
ALTER TABLE
    `delivery` ADD CONSTRAINT `delivery_dmid_foreign` FOREIGN KEY(`dmid`) REFERENCES `deliveryman`(`dmid`) ON DELETE CASCADE;
ALTER TABLE
    `orderDetail` ADD CONSTRAINT `orderdetail_wid_foreign` FOREIGN KEY(`wid`) REFERENCES `waiter`(`wid`) ON DELETE CASCADE;
ALTER TABLE
    `reservation` ADD CONSTRAINT `reservation_recid_foreign` FOREIGN KEY(`recid`) REFERENCES `receptionist`(`recid`) ON DELETE CASCADE;
ALTER TABLE
    `orders` ADD CONSTRAINT `orders_mid_foreign` FOREIGN KEY(`mid`) REFERENCES `menu`(`mid`) ON DELETE CASCADE;
ALTER TABLE
    `orders` ADD CONSTRAINT `orders_oid_foreign` FOREIGN KEY(`oid`) REFERENCES `orderdetail`(`oid`) ON DELETE CASCADE;