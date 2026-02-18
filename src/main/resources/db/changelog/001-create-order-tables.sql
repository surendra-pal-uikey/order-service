-- liquibase formatted sql

-- changeset admin:001-create-order-tables
DROP TABLE IF EXISTS ORDERS;

CREATE TABLE ORDERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    product_name VARCHAR(255),
    quantity INT,
    status VARCHAR(255),
    order_date DATE
);
