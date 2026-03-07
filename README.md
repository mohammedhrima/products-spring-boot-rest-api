# Products REST API 🛍️

A RESTful API for managing product inventory built with Spring Boot. Perform CRUD operations on products with a robust, scalable backend architecture.

## 🎯 What Does It Do?

This API provides a complete backend solution for managing products in an e-commerce or inventory system. You can:

- **Create Products**: Add new products with details like name, description, price, quantity, and category
- **Read Products**: Retrieve all products or find specific products by ID
- **Update Products**: Modify existing product information and inventory levels
- **Delete Products**: Remove products from the catalog
- **Inventory Management**: Track stock levels and product availability
- **Search & Filter**: Find products by category, price range, or availability

## 👤 Who Is It For?

- E-commerce developers building online stores
- Backend developers learning Spring Boot
- Inventory managers needing a product management system
- Students building full-stack applications
- Teams developing retail or warehouse management systems

## 🚀 How to Use

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite API testing tool (Postman, Insomnia, or curl)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd products-spring-boot-rest-api
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The API will start on `http://localhost:8080`

### API Endpoints

#### Get All Products
```http
GET /api/products
```
Returns a list of all products in the inventory.

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse with USB receiver",
    "price": 29.99,
    "quantity": 150,
    "category": "Electronics",
    "inStock": true
  }
]
```

#### Get Product by ID
```http
GET /api/products/{id}
```
Returns a specific product by its ID.

#### Create a New Product
```http
POST /api/products
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Mechanical Keyboard",
  "description": "RGB backlit mechanical gaming keyboard",
  "price": 89.99,
  "quantity": 75,
  "category": "Electronics"
}
```

#### Update a Product
```http
PUT /api/products/{id}
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Mechanical Keyboard Pro",
  "description": "RGB backlit mechanical gaming keyboard with macro keys",
  "price": 99.99,
  "quantity": 50,
  "category": "Electronics"
}
```

#### Delete a Product
```http
DELETE /api/products/{id}
```
Removes the product with the specified ID.

#### Search Products by Category
```http
GET /api/products/category/{category}
```
Returns all products in a specific category.

#### Check Product Availability
```http
GET /api/products/{id}/availability
```
Returns stock status and quantity available.

### Testing with curl

```bash
# Get all products
curl http://localhost:8080/api/products

# Create a new product
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "USB-C Cable",
    "description": "6ft braided USB-C charging cable",
    "price": 12.99,
    "quantity": 200,
    "category": "Accessories"
  }'

# Update product quantity
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse with USB receiver",
    "price": 29.99,
    "quantity": 100,
    "category": "Electronics"
  }'

# Delete a product
curl -X DELETE http://localhost:8080/api/products/1
```

## 🛠️ Technical Stack

- **Spring Boot 4.0.1**: Modern Java framework for building web applications
- **Spring Web MVC**: RESTful web services
- **Spring Data JPA**: Database access and ORM
- **H2 Database**: In-memory database for development and testing
- **Bean Validation**: Input validation
- **Maven**: Dependency management and build tool
- **Java 17**: Programming language

## 📁 Project Architecture

```
products-spring-boot-rest-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/products/
│   │   │       ├── model/          # Product entity
│   │   │       ├── controller/     # REST endpoints
│   │   │       ├── service/        # Business logic
│   │   │       ├── repository/     # Database operations
│   │   │       └── dto/            # Data transfer objects
│   │   └── resources/
│   │       └── application.properties
│   └── test/                       # Tests
└── pom.xml
```

### Architecture Layers

1. **Model Layer**: Product entity with JPA annotations
2. **Repository Layer**: Database operations using Spring Data JPA
3. **Service Layer**: Business logic, validation, and inventory management
4. **Controller Layer**: REST endpoints and HTTP handling
5. **DTO Layer**: Data transfer objects for API requests/responses

## 🔧 Configuration

### Database Configuration

The application uses H2 in-memory database by default. Access the console at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:productdb`
- Username: `sa`
- Password: (empty)

### Application Properties

```properties
# Server
server.port=8080

# Database
spring.datasource.url=jdbc:h2:mem:productdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
```

## 📊 Data Model

### Product Entity

| Field | Type | Description | Validation |
|-------|------|-------------|------------|
| id | Long | Primary key | Auto-generated |
| name | String | Product name | Required, max 100 chars |
| description | String | Product description | Optional, max 500 chars |
| price | Double | Product price | Required, min 0.01 |
| quantity | Integer | Stock quantity | Required, min 0 |
| category | String | Product category | Required |
| inStock | Boolean | Availability status | Computed |
| createdAt | LocalDateTime | Creation timestamp | Auto-generated |
| updatedAt | LocalDateTime | Last update timestamp | Auto-updated |

## 🧪 Testing

Run tests:
```bash
mvn test
```

Includes:
- Unit tests for service layer
- Integration tests for REST endpoints
- Repository tests
- Validation tests

## 🚀 Deployment

### Build JAR

```bash
mvn clean package
java -jar target/products-api-0.0.1-SNAPSHOT.jar
```

### Docker Deployment

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/products-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

```bash
docker build -t products-api .
docker run -p 8080:8080 products-api
```

## 📈 Future Enhancements

- [ ] Product images and galleries
- [ ] Advanced search and filtering
- [ ] Pagination and sorting
- [ ] Product reviews and ratings
- [ ] Inventory alerts for low stock
- [ ] Bulk import/export (CSV, Excel)
- [ ] Price history tracking
- [ ] Multi-currency support
- [ ] Integration with payment gateways
- [ ] MySQL/PostgreSQL support

## 🤝 Contributing

Contributions are welcome! Great project for learning Spring Boot and REST API design.

## 📄 License

This project is open source and available for educational purposes.
