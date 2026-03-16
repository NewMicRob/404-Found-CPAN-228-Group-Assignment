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
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Basic Cotton T-Shirt', 19.99, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Graphic Print T-Shirt', 24.99, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Slim Fit T-Shirt', 22.50, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Cartoon T-Shirt', 14.99, 0.05, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Sports T-Shirt', 15.99, 0.05, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('V-Neck T-Shirt', 21.99, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Vintage Logo T-Shirt', 26.99, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Performance T-Shirt', 29.99, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Long Sleeve T-Shirt', 27.50, 0.13, 4, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Pocket T-Shirt', 23.99, 0.13, 4, false);

-- Shirts (category_id = 5)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Formal White Shirt', 39.99, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Casual Linen Shirt', 44.99, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Slim Fit Office Shirt', 42.50, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Checkered Shirt', 19.99, 0.05, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Denim Button-Up Shirt', 49.99, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Hawaiian Print Shirt', 38.99, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Oxford Dress Shirt', 52.99, 0.13, 5, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Flannel Shirt', 41.99, 0.13, 5, false);

-- Hoodies (category_id = 6)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Classic Pullover Hoodie', 49.99, 0.13, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Zip-Up Hoodie', 54.99, 0.13, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Sport Training Hoodie', 59.99, 0.13, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Warm Hoodie', 29.99, 0.05, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Oversized Hoodie', 64.99, 0.13, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Tech Fleece Hoodie', 79.99, 0.13, 6, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Logo Hoodie', 32.99, 0.05, 6, false);

-- Jeans (category_id = 7)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Regular Fit Jeans', 69.99, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Slim Fit Blue Jeans', 74.99, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Black Denim Jeans', 72.50, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Stretch Jeans', 34.99, 0.05, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Bootcut Jeans', 71.99, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Distressed Jeans', 79.99, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Skinny Fit Jeans', 76.50, 0.13, 7, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Relaxed Fit Jeans', 68.99, 0.13, 7, false);

-- Shorts (category_id = 8)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Summer Cotton Shorts', 29.99, 0.13, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Sport Running Shorts', 27.99, 0.13, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Denim Shorts', 32.50, 0.13, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Playground Shorts', 18.99, 0.05, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Cargo Shorts', 34.99, 0.13, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Chino Shorts', 36.99, 0.13, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Swim Shorts', 22.99, 0.05, 8, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Athletic Shorts', 31.99, 0.13, 8, false);

-- Hats (category_id = 9)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Baseball Cap', 16.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Winter Beanie', 19.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Snapback Hat', 21.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Sun Hat', 12.99, 0.05, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Bucket Hat', 24.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Fedora Hat', 44.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Trucker Hat', 18.99, 0.13, 9, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Winter Cap', 14.99, 0.05, 9, false);

-- Belts (category_id = 10)
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Classic Leather Belt', 34.99, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Casual Fabric Belt', 24.99, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Black Formal Belt', 36.99, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Kids Elastic Belt', 14.99, 0.05, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Brown Leather Belt', 35.50, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Reversible Belt', 39.99, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Canvas Web Belt', 19.99, 0.13, 10, false);
INSERT INTO products (name, price, tax_rate, category_id, deleted) VALUES ('Braided Leather Belt', 42.99, 0.13, 10, false);

-- Deliveries
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (1, 1, 100, 10.50, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (6, 3, 50, 22.00, CURRENT_TIMESTAMP, 'Company B', 'PENDING');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (2, 2, 120, 12.00, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (3, 1, 80, 11.25, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (11, 2, 60, 20.50, CURRENT_TIMESTAMP, 'Company B', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (19, 3, 75, 24.00, CURRENT_TIMESTAMP, 'Company A', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (26, 4, 90, 35.00, CURRENT_TIMESTAMP, 'Company D', 'PENDING');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (34, 1, 110, 14.50, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (42, 3, 45, 8.00, CURRENT_TIMESTAMP, 'Company B', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (49, 2, 95, 17.50, CURRENT_TIMESTAMP, 'Company A', 'PENDING');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (15, 4, 65, 27.00, CURRENT_TIMESTAMP, 'Company D', 'RECEIVED');
INSERT INTO product_supplies (product_id, warehouse_id, quantity_received, unit_cost, delivery_date, delivered_by, status) VALUES (22, 1, 85, 31.00, CURRENT_TIMESTAMP, 'Company C', 'RECEIVED');

-- Shipments
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (1, 1, 20, 399.80, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (15, 2, 5, 249.95, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (2, 2, 30, 749.70, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (11, 1, 10, 399.90, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (19, 3, 15, 749.85, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (26, 4, 8, 575.92, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (34, 1, 25, 749.75, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (42, 3, 12, 203.88, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (3, 1, 22, 495.00, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (7, 2, 18, 485.82, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (28, 4, 14, 349.86, CURRENT_TIMESTAMP);
INSERT INTO shipments (product_id, warehouse_id, quantity_shipped, shipment_value, shipment_date) VALUES (37, 3, 10, 369.90, CURRENT_TIMESTAMP);

-- Stock
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (1, 1, 80, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (2, 2, 75, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (6, 1, 3, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (9, 3, 40, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (3, 1, 58, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (4, 2, 92, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (5, 3, 68, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (7, 2, 42, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (8, 1, 55, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (10, 3, 48, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (11, 4, 50, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (12, 1, 73, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (13, 2, 61, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (14, 4, 82, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (15, 2, 5, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (16, 3, 37, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (18, 1, 44, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (19, 3, 60, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (20, 2, 51, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (22, 1, 85, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (26, 4, 82, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (28, 4, 56, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (30, 2, 39, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (34, 1, 85, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (37, 3, 62, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (42, 3, 33, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (45, 1, 66, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (49, 2, 95, CURRENT_TIMESTAMP);
INSERT INTO inventory (product_id, warehouse_id, quantity, last_updated) VALUES (50, 4, 47, CURRENT_TIMESTAMP);