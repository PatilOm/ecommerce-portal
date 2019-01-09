CREATE TABLE category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category(name,description,image_url,is_active) VALUES('LAPTOP','Description','CAT_1.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('KEYBOARD','Description','CAT_2.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('MOUSE','Description','CAT_3.png',true);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Omkar','Patil','ADMIN',true,'admin','op@gmail.com','88888888');
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Akash','Patil','SUPPLIER',true,'12345','ap@gmail.com','77777777');
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Ramesh','Patil','USER',true,'12345','rp@gmail.com','77777888');

CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123', 'YOGA', 'LENOVO', 'This is some description', 45000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123', 'CURVE', 'LOGITECH', 'This is some description', 1000, 5, true, 2, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDEFG456', 'PIANO', 'iBALL', 'This is some description', 500, 3, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC456', 'SURFACE', 'MICROSOFT', 'This is some description', 85000, 2, true, 1, 2, 0, 0 );

CREATE TABLE cart_line(
id IDENTITY,
cart_id int,
total DECIMAL(10,2),
product_id int,
product_count int,
buying_price DECIMAL(10,2),
is_available boolean,
CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart (id),
CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product (id),
CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);