DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT,
    registered TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    email_address VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(5) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address_line_1 VARCHAR(255) NOT NULL,
    address_line_2 VARCHAR(255),
    city VARCHAR(255),
    postcode VARCHAR(10) NOT NULL,
    phone_number VARCHAR(20),
    PRIMARY KEY(id)
);