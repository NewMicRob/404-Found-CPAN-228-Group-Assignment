SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE product_supplies;
TRUNCATE TABLE shipments;
TRUNCATE TABLE inventory;
TRUNCATE TABLE products;
TRUNCATE TABLE warehouses;
TRUNCATE TABLE categories;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

-- CATEGORIES
-- Parent categories
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (1, 'Tops', NULL);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (2, 'Bottoms', NULL);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (3, 'Accessories', NULL);

-- Children  of Tops (parent_id = 1)
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (4, 'T-Shirts', 1);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (5, 'Shirts', 1);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (6, 'Hoodies', 1);

-- Children of Bottoms (parent_id = 2)
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (7, 'Jeans', 2);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (8, 'Shorts', 2);

-- Children of Accessories (parent_id = 3)
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (9, 'Hats', 3);
INSERT IGNORE INTO categories (id, name, parent_id) VALUES (10, 'Belts', 3);

-- WAREHOUSES
INSERT IGNORE INTO warehouses (id, name, address) VALUES (1, 'Main Warehouse', '123 Industrial Ave, Toronto');
INSERT IGNORE INTO warehouses (id, name, address) VALUES (2, 'Downtown Storage', '45 King St W, Toronto');
INSERT IGNORE INTO warehouses (id, name, address) VALUES (3, 'North Distribution Center', '890 Finch Ave W, Toronto');
INSERT IGNORE INTO warehouses (id, name, address) VALUES (4, 'East Logistics Hub', '2100 Markham Rd, Scarborough');

-- PRODUCTS
-- T-Shirts (category_id = 4)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (1, 'Basic Cotton T-Shirt', 19.99, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (2, 'Graphic Print T-Shirt', 24.99, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (3, 'Slim Fit T-Shirt', 22.50, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (4, 'Kids Cartoon T-Shirt', 14.99, 0.05, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (5, 'Kids Sports T-Shirt', 15.99, 0.05, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (6, 'V-Neck T-Shirt', 21.99, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (7, 'Vintage Logo T-Shirt', 26.99, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (8, 'Performance T-Shirt', 29.99, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (9, 'Long Sleeve T-Shirt', 27.50, 0.13, 4, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (10, 'Pocket T-Shirt', 23.99, 0.13, 4, false);

-- Shirts (category_id = 5)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (11, 'Formal White Shirt', 39.99, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (12, 'Casual Linen Shirt', 44.99, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (13, 'Slim Fit Office Shirt', 42.50, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (14, 'Kids Checkered Shirt', 19.99, 0.05, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (15, 'Denim Button-Up Shirt', 49.99, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (16, 'Hawaiian Print Shirt', 38.99, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (17, 'Oxford Dress Shirt', 52.99, 0.13, 5, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (18, 'Flannel Shirt', 41.99, 0.13, 5, false);

-- Hoodies (category_id = 6)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (19, 'Classic Pullover Hoodie', 49.99, 0.13, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (20, 'Zip-Up Hoodie', 54.99, 0.13, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (21, 'Sport Training Hoodie', 59.99, 0.13, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (22, 'Kids Warm Hoodie', 29.99, 0.05, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (23, 'Oversized Hoodie', 64.99, 0.13, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (24, 'Tech Fleece Hoodie', 79.99, 0.13, 6, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (25, 'Kids Logo Hoodie', 32.99, 0.05, 6, false);

-- Jeans (category_id = 7)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (26, 'Regular Fit Jeans', 69.99, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (27, 'Slim Fit Blue Jeans', 74.99, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (28, 'Black Denim Jeans', 72.50, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (29, 'Kids Stretch Jeans', 34.99, 0.05, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (30, 'Bootcut Jeans', 71.99, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (31, 'Distressed Jeans', 79.99, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (32, 'Skinny Fit Jeans', 76.50, 0.13, 7, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (33, 'Relaxed Fit Jeans', 68.99, 0.13, 7, false);

-- Shorts (category_id = 8)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (34, 'Summer Cotton Shorts', 29.99, 0.13, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (35, 'Sport Running Shorts', 27.99, 0.13, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (36, 'Denim Shorts', 32.50, 0.13, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (37, 'Kids Playground Shorts', 18.99, 0.05, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (38, 'Cargo Shorts', 34.99, 0.13, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (39, 'Chino Shorts', 36.99, 0.13, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (40, 'Kids Swim Shorts', 22.99, 0.05, 8, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (41, 'Athletic Shorts', 31.99, 0.13, 8, false);

-- Hats (category_id = 9)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (42, 'Baseball Cap', 16.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (43, 'Winter Beanie', 19.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (44, 'Snapback Hat', 21.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (45, 'Kids Sun Hat', 12.99, 0.05, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (46, 'Bucket Hat', 24.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (47, 'Fedora Hat', 44.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (48, 'Trucker Hat', 18.99, 0.13, 9, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (49, 'Kids Winter Cap', 14.99, 0.05, 9, false);

-- Belts (category_id = 10)
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (50, 'Classic Leather Belt', 34.99, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (51, 'Casual Fabric Belt', 24.99, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (52, 'Black Formal Belt', 36.99, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (53, 'Kids Elastic Belt', 14.99, 0.05, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (54, 'Brown Leather Belt', 35.50, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (55, 'Reversible Belt', 39.99, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (56, 'Canvas Web Belt', 19.99, 0.13, 10, false);
INSERT IGNORE INTO products (id, name, price, tax_rate, category_id, deleted) VALUES (57, 'Braided Leather Belt', 42.99, 0.13, 10, false);

-- Deliveries
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (1, 1, 100, 10.50, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (6, 3, 50, 22.00, CURRENT_TIMESTAMP, 'Company B', 'PENDING');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (2, 2, 120, 12.00, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (3, 1, 80, 11.25, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (11, 2, 60, 20.50, CURRENT_TIMESTAMP, 'Company B', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (19, 3, 75, 24.00, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (26, 4, 90, 35.00, CURRENT_TIMESTAMP, 'Company D', 'PENDING');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (34, 1, 110, 14.50, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (42, 3, 45, 8.00, CURRENT_TIMESTAMP, 'Company B', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (49, 2, 95, 17.50, CURRENT_TIMESTAMP, 'Company A', 'PENDING');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (15, 4, 65, 27.00, CURRENT_TIMESTAMP, 'Company D', 'RECEIVED');
INSERT IGNORE INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (22, 1, 85, 31.00, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');

-- Shipments
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (1, 1, 20, 399.80, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (15, 2, 5, 249.95, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (2, 2, 30, 749.70, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (11, 1, 10, 399.90, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (19, 3, 15, 749.85, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (26, 4, 8, 575.92, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (34, 1, 25, 749.75, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (42, 3, 12, 203.88, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (3, 1, 22, 495.00, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (7, 2, 18, 485.82, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (28, 4, 14, 349.86, CURRENT_TIMESTAMP);
INSERT IGNORE INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (37, 3, 10, 369.90, CURRENT_TIMESTAMP);

-- Stock
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (1, 1, 80, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (2, 2, 75, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (6, 1, 3, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (9, 3, 40, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (3, 1, 58, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (4, 2, 92, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (5, 3, 68, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (7, 2, 42, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (8, 1, 55, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (10, 3, 48, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (11, 4, 50, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (12, 1, 73, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (13, 2, 61, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (14, 4, 82, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (15, 2, 5, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (16, 3, 37, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (18, 1, 44, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (19, 3, 60, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (20, 2, 51, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (22, 1, 85, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (26, 4, 82, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (28, 4, 56, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (30, 2, 39, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (34, 1, 85, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (37, 3, 62, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (42, 3, 33, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (45, 1, 66, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (49, 2, 95, CURRENT_TIMESTAMP);
INSERT IGNORE INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (50, 4, 47, CURRENT_TIMESTAMP);

-- Users | Password for all the users - password123
INSERT IGNORE INTO users (username, password, role) VALUES ('Alex', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'STAFF');
INSERT IGNORE INTO users (username, password, role) VALUES ('Ben', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'VIEWER');
INSERT IGNORE INTO users (username, password, role) VALUES ('Chris', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'STAFF');
INSERT IGNORE INTO users (username, password, role) VALUES ('David', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'VIEWER');
INSERT IGNORE INTO users (username, password, role) VALUES ('Emma', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'STAFF');
INSERT IGNORE INTO users (username, password, role) VALUES ('Fiona', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'VIEWER');
INSERT IGNORE INTO users (username, password, role) VALUES ('George', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'STAFF');
INSERT IGNORE INTO users (username, password, role) VALUES ('Hannah', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'VIEWER');
INSERT IGNORE INTO users (username, password, role) VALUES ('Ivan', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'STAFF');
INSERT IGNORE INTO users (username, password, role) VALUES ('Julia', '$2a$10$twpRa12mTwBE/7ds3Bkj1uIKexad6Ni1/Ts30mAuZQClrgbJEuahW', 'VIEWER');