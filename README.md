# products-spring-boot-rest-api

A small REST API for managing products, built with Spring Boot and Spring Data JPA on
an in-memory H2 database.

## Run

```bash
./mvnw spring-boot:run
```

Starts on http://localhost:8080 (H2 console at `/h2-console`).

## Endpoints

- `GET    /api/product` — list all products
- `POST   /api/product` — create a product
- `GET    /api/product/{id}` — get one product
- `DELETE /api/product/{id}` — delete a product
