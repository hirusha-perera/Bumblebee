CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_email` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM bumblebee.purchases;

CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_firstName` varchar(45) NOT NULL,
  `customer_lastName` varchar(45) NOT NULL,
  `customer_nic` varchar(15) NOT NULL,
  `customer_dob` date DEFAULT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_telephone` varchar(15) NOT NULL,
  `customer_address` varchar(50) NOT NULL,
  `customer_state` varchar(50) NOT NULL,
  `customer_password` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cus_account` (
  `cus_id` int NOT NULL,
  `cus_limit` decimal(10,2) DEFAULT NULL,
  `cus_used` decimal(10,2) DEFAULT NULL,
  `cus_balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`cus_id`),
  CONSTRAINT `fk_cusId` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `purchases` (
  `purchase_id` int NOT NULL AUTO_INCREMENT,
  `purchased_customer` int NOT NULL,
  `purchased_product` varchar(45) NOT NULL,
  `purchased_quantity` int NOT NULL,
  `purchased_amount` decimal(10,2) NOT NULL,
  `installment_amount` decimal(10,2) DEFAULT NULL,
  `purchased_date` date DEFAULT NULL,
  PRIMARY KEY (`purchase_id`),
  KEY `fk_purchasedCustomer_idx` (`purchased_customer`),
  CONSTRAINT `fk_purchasedCustomer` FOREIGN KEY (`purchased_customer`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `product_description` varchar(255) NOT NULL,
  `product_quantity` int NOT NULL,
  `product_price` varchar(50) NOT NULL,
  `product_image` mediumblob,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `updated_customers` (
  `update_date` datetime NOT NULL,
  `update_customerId` int NOT NULL,
  `update_customerFirstname` varchar(45) DEFAULT NULL,
  `update_customerLastname` varchar(45) DEFAULT NULL,
  `update_customerNIC` varchar(15) DEFAULT NULL,
  `update_customerDOB` date DEFAULT NULL,
  `update_customerAddress` varchar(50) DEFAULT NULL,
  `update_customerState` varchar(50) DEFAULT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`update_date`,`update_customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELIMITER //

CREATE TRIGGER insert_payment AFTER INSERT ON purchases
FOR EACH ROW
BEGIN
    INSERT INTO payments (purchased_id, total_amount, first_installment, second_installment, third_installment)
    VALUES (NEW.purchase_id, NEW.purchased_amount, NEW.installment_amount, 0, 0);
END//

DELIMITER //


CREATE TRIGGER `purchases_BEFORE_INSERT` BEFORE INSERT ON `purchases` FOR EACH ROW BEGIN
SET NEW.installment_amount = NEW.purchased_amount / 3;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER customer_update_trigger
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
  INSERT INTO updated_customers (update_date, update_customerId, update_customerFirstname, update_customerLastname, update_customerNIC, update_customerDOB, update_customerAddress, update_customerState)
  VALUES (NOW(), OLD.customer_id, OLD.customer_firstName, OLD.customer_lastName, OLD.customer_nic, OLD.customer_dob, OLD.customer_address, OLD.customer_state);
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER send_username
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
    DECLARE customer_id INT;
    DECLARE customer_email VARCHAR(255);
    DECLARE subject VARCHAR(255);
    DECLARE text VARCHAR(255);
    
    SET customer_id = NEW.customer_id;
    SET customer_email = NEW.customer_email;
    SET subject = 'Welcome to Bumblebee';
    SET text = CONCAT('Your username is: ', customer_id);
    
    CALL send_email(customer_email, subject, text);
END//

DELIMITER ;


DELIMITER //

CREATE PROCEDURE send_email(IN to_email VARCHAR(255), IN subject VARCHAR(255), IN text VARCHAR(255))
BEGIN
    DECLARE host VARCHAR(255);
    DECLARE port INT;
    DECLARE username VARCHAR(255);
    DECLARE password VARCHAR(255);
    
    SET host = 'your_smtp_host';
    SET port = your_smtp_port;
    SET username = 'your_email_username';
    SET password = 'your_email_password';
    
    # create email message
    SET @msg = CONCAT('From: ', username, '\r\n');
    SET @msg = CONCAT(@msg, 'To: ', to_email, '\r\n');
    SET @msg = CONCAT(@msg, 'Subject: ', subject, '\r\n\r\n');
    SET @msg = CONCAT(@msg, text);
    
    # send email using SMTP
    SET @result = send_email_smtp(host, port, username, password, to_email, subject, @msg);
END//

DELIMITER ;
