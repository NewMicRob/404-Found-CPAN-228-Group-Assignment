# StockFlow


## Overview
This project is an inventory management system for a multi-location warehouse setup. It helps manage products, categories, and stock levels across different warehouses, while keeping inventory data consistent and up to date.

Users can manage products across different categories, as well as categories and subcategories. The system supports inventory management, where users can track product quantities, deliveries, and shipments. The home page provides different reports to give a clear overview of the system’s data.

The application includes registration and login functionality. Admin users can additionally manage other users through a dedicated admin panel.

The system is built as a web application and runs in Docker for easier setup and deployment. It uses an H2 in-memory database for the main application, and a MySQL database in a separate container for QA/testing purpos


## Domain
  - Product
  - Category
  - Warehouse
  - Inventory
  - Delivery
  - Shipment
  - User


## Roles and Access

The system has three types of users with different permissions:

| Role   | Can view all pages & reports | Can add and update data | Can add Categories and Warehouses / Admin access |
|--------|------------------------------|-------------------------|--------------------------------------------------|
| Admin  | Yes                          | Yes                     | Yes                                              |
| Staff  | Yes                          | Yes                     | No                                               |
| Viewer | Yes                          | No                      | No                                               |

- Admin – has full access to everything, including the Admin tab. Can manage categories, warehouses, and all system data.
- Staff – can view all pages and reports and update data, but cannot access admin features like creating categories or warehouses.
- Viewer – can only view data and reports, without

## UI Layout

### Registration
* Allows users to create an account. During registration, the user can select a user type: Viewer or Staff.

### Login Page
* Provides secure user authentication to access the system.

### Home
* Serves as the main dashboard of the application. 
It provides quick access to key actions such as adding products, shipments, and deliveries (available for Admin and Staff users).
It also displays inventory reports using charts, including product distribution, warehouse stock levels, and category/subcategory breakdowns.

### Products
* Shows a list of all products with details like name, price, tax rate, and category. 
Users can add, update, and delete products depending on their permissions.
It also includes filtering, sorting, and pagination to easily search and navigate through products. 
The page contains modals for adding and updating products, as well as adding categories. 
A collapsible section allows users to view all categories.

### Inventory
* Shows a list of all products with their current stock levels in different warehouses. 
It includes details such as product name, quantity, and warehouse.
Users can search, sort, and navigate through inventory using pagination. 
Low stock items are highlighted for better visibility.
Users can also update stock levels using an update form, and there is a modal for bulk inventory updates (available for Admin and Staff users).

### Deliveries
* Displays a list of all product deliveries, including details such as product name, supplier, warehouse, quantity, unit cost, total cost, delivery date, and status.
Users can search deliveries by product or supplier and view quick summary badges for pending and received deliveries. 
The page also includes a modal for adding new deliveries (available for Admin and Staff users).

### Shipments
* Displays a list of all outgoing shipments, including product, warehouse, quantity shipped, shipment value, and shipment date.
Users can search shipments by product and view a summary of the total number of shipments. 
The page also includes a modal for creating new shipments (available for Admin and Staff users).

### Warehouses
* Displays a list of all warehouses in the system, including their ID, name, and address.
Users can view existing warehouses, and Admin can add new warehouses through a modal form.

### Admin Interface
* Displays a list of all users with their ID, username, and role.
Admin can search users by username, as well as update or delete users (except Admin user). 
The page includes an update modal for editing user details.

## Tech Stack
  **Languages:** Spring, Java, HTML  
  **Build:** Maven  
  **UI:** Bootstrap CSS, and Thymeleaf
  **Infrastructure:** Docker


## How to Run
This project uses Spring Boot Profiles to switch between enviornments automatically depending on how the application is launched. No code changes are required to switch between the Dev enviornment, and the Qa(Quality Assurance) Enviornment. 

### Dev Enviornment
1. Open Code Editor (Vs Code, or IntelliJ)
2. Click play when viewing the application file(Green button top right fo editor)
3. The console will display Profile DEV.
4. Go to: [http://localhost:8080](http://localhost:8080)

### QA Enviornment
1. Open Docker Desktop and ensure it’s started
2. Open the project folder in Terminal `cd 404-Found-CPAN-228-Group-Assignment/`
3. Build the Docker Images and start them `docker compose up --build -d`
4. The console will display Profile QA.
5. Go to: [http://localhost:8080](http://localhost:8080)


## Created by
#### Group 404 Found:
- **[Iuliia Bazhutina](https://github.com/IuliiaBazhutina)**
  - My background is in accounting, and developing this warehouse management system allows me to combine my programming skills with my accounting experience.
    I’m excited to bring this project to life.
- **[Michael Newman](https://github.com/NewMicRob)**
  - My name is Michael R Newman, I am looking forward to creating our webisite as a member of 404 Found,
    being that this is my final semester in the computer programming program this will be one of my final projects while being enrolled in the Computer Programming Program at Humber Polytechnic.


## Task division
| Feature          | Iuliia Bazhutina                                                                                                                                                                                | Michael Newman                                                                                                                                                                                                                                                             |
|:-----------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Models**       | • Product<br>• Category<br>• User                                                                                                                                                               | • Inventory<br>• Delivery<br>• Shipment<br>• Warehouse                                                                                                                                                                                                                     |
| **Repositories** | • ProductRepository<br>• CategoryRepository<br>• UserRepository                                                                                                                                 | • InventoryRepository<br>• DeliveryRepository<br>• ShipmentRepository<br>• WarehouseRepository                                                                                                                                                                             |
| **Services**     | • ProductService<br>• CategoryService<br>• UserService                                                                                                                                          | • InventoryService<br>• DeliveryService<br>• ShipmentService<br>• WarehouseService                                                                                                                                                                                         |
| **Controllers**  | • ProductController<br>• AdminController<br>• LoginController                                                                                                                                   | • InventoryController<br>• DeliveryController<br>• ShipmentController<br>• WarehouseController                                                                                                                                                                             |
| **Templates**    | • products.html<br>• admin.html<br>• login.html<br>• categoriesTable.html<br>• createCategory_modal.html<br>• createProduct_modal.html<br>• updateProduct_modal.html<br>• updateUser_modal.html | • home.html<br>•inventory.html<br>• deliveries.html<br>• shipments.html<br>• warehouses.html<br>• register.html<br>• createDelivery_modal.html<br>• createShipment_modal.html<br>• createWarehouse_modal.html<br>• footer.html<br>• navbar.html<br>• updateInventory_modal.html |
| **Docker**       | • Dockerized Application & Database                                                                                           | • Environment Configuration (Profiles)                                                                                                                                                                                                                                     |
