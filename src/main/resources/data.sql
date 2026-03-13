-- CATEGORIES
-- Parent categories
INSERT INTO categories (name, parent_id) VALUES ('Tops', NULL);
INSERT INTO categories (name, parent_id) VALUES ('Bottoms', NULL);
INSERT INTO categories (name, parent_id) VALUES ('Accessories', NULL);

-- Children  of Tops (parent_id = 1)
INSERT INTO categories (name, parent_id) VALUES ('T-Shirts', 1);
INSERT INTO categories (name, parent_id) VALUES ('Shirts', 1);
INSERT INTO categories (name, parent_id) VALUES ('Hoodies', 1);

-- Children of Bottoms (parent_id = 2)
INSERT INTO categories (name, parent_id) VALUES ('Jeans', 2);
INSERT INTO categories (name, parent_id) VALUES ('Shorts', 2);

-- Children of Accessories (parent_id = 3)
INSERT INTO categories (name, parent_id) VALUES ('Hats', 3);
INSERT INTO categories (name, parent_id) VALUES ('Belts', 3);

-- WAREHOUSES
INSERT INTO warehouses (name, address) VALUES ('Main Warehouse', '123 Industrial Ave, Toronto');
INSERT INTO warehouses (name, address) VALUES ('Downtown Storage', '45 King St W, Toronto');
INSERT INTO warehouses (name, address) VALUES ('North Distribution Center', '890 Finch Ave W, Toronto');
INSERT INTO warehouses (name, address) VALUES ('East Logistics Hub', '2100 Markham Rd, Scarborough');

-- PRODUCTS
-- T-Shirts (category_id = 4)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Basic Cotton T-Shirt', 19.99, 0.13, 4);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Graphic Print T-Shirt', 24.99, 0.13, 4);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Slim Fit T-Shirt', 22.50, 0.13, 4);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Cartoon T-Shirt', 14.99, 0.05, 4);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Sports T-Shirt', 15.99, 0.05, 4);

-- Shirts (category_id = 5)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Formal White Shirt', 39.99, 0.13, 5);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Casual Linen Shirt', 44.99, 0.13, 5);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Slim Fit Office Shirt', 42.50, 0.13, 5);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Checkered Shirt', 19.99, 0.05, 5);

-- Hoodies (category_id = 6)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Classic Pullover Hoodie', 49.99, 0.13, 6);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Zip-Up Hoodie', 54.99, 0.13, 6);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Sport Training Hoodie', 59.99, 0.13, 6);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Warm Hoodie', 29.99, 0.05, 6);

-- Jeans (category_id = 7)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Regular Fit Jeans', 69.99, 0.13, 7);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Slim Fit Blue Jeans', 74.99, 0.13, 7);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Black Denim Jeans', 72.50, 0.13, 7);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Stretch Jeans', 34.99, 0.05, 7);

-- Shorts (category_id = 8)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Summer Cotton Shorts', 29.99, 0.13, 8);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Sport Running Shorts', 27.99, 0.13, 8);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Denim Shorts', 32.50, 0.13, 8);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Playground Shorts', 18.99, 0.05, 8);

-- Hats (category_id = 9)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Baseball Cap', 16.99, 0.13, 9);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Winter Beanie', 19.99, 0.13, 9);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Snapback Hat', 21.99, 0.13, 9);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Sun Hat', 12.99, 0.05, 9);

-- Belts (category_id = 10)
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Classic Leather Belt', 34.99, 0.13, 10);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Casual Fabric Belt', 24.99, 0.13, 10);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Black Formal Belt', 36.99, 0.13, 10);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Kids Elastic Belt', 14.99, 0.05, 10);
INSERT INTO products (name, price, tax_rate, category_id) VALUES ('Brown Leather Belt', 35.50, 0.13, 10);

-- Deliveries
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (1, 1, 100, 10.50, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (6, 3, 50, 22.00, CURRENT_TIMESTAMP, 'Company B', 'PENDING');

-- Shipments
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (1, 1, 20, 399.80, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (15, 2, 5, 374.95, CURRENT_TIMESTAMP);

-- Stock
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (1, 1, 80, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (2, 2, 75, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (6, 1, 3, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (9, 3, 40, CURRENT_TIMESTAMP);