create database electro
use electro

CREATE TABLE `User` (
    user_id VARCHAR(100) PRIMARY KEY,
    username VARCHAR(100),
    email VARCHAR(255),
    phone VARCHAR(20),
    address NVARCHAR(500),
    role INT
);

CREATE TABLE `Order` (
    order_id VARCHAR(100) PRIMARY KEY,
    user_id VARCHAR(100),
    order_time DATETIME,
    total_amount DECIMAL(10,2),
    status INT,
    FOREIGN KEY (user_id) REFERENCES `User`(user_id)
);

CREATE TABLE order_item (
    order_item_id VARCHAR(100) PRIMARY KEY,
    order_id VARCHAR(100),
    quantity INT,
    price DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id)
);



CREATE TABLE cart (
    cart_id VARCHAR(100) PRIMARY KEY,
    user_id VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE category (
    category_id VARCHAR(100) PRIMARY KEY,
    category_parent_id VARCHAR(100),
    name NVARCHAR(255),
    description NVARCHAR(1000),
    FOREIGN KEY (category_parent_id) REFERENCES Category(category_id)
);

CREATE TABLE Product (
    product_id VARCHAR(100) PRIMARY KEY,
    category_id VARCHAR(100),
    order_item_id VARCHAR(100),
    name NVARCHAR(255),
    description NVARCHAR(1000),
    price DECIMAL(10,2),
    quantity_in_stock INT,
    image_url VARCHAR(255),
    FOREIGN KEY (category_id) REFERENCES Category(category_id),
    FOREIGN KEY (order_item_id) REFERENCES order_item(order_item_id)
);
CREATE TABLE cart_item (
    cart_item_id VARCHAR(100) PRIMARY KEY,
    cart_id VARCHAR(100),
    product_id VARCHAR(100),
    quantity INT,
    FOREIGN KEY (cart_id) REFERENCES Cart(cart_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);
CREATE TABLE Review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id VARCHAR(100),
    user_id VARCHAR(100),
    time DATETIME,
    FOREIGN KEY (product_id) REFERENCES Product(product_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);





 