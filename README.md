# Equipamentos

## Getting Started

### Prerequisites
- Git
- Maven 3.0+
- JDK 8+

### Clone

To get started you can simply clone this repository using git:
```
git clone https://github.com/devmanfredi/api-equipment.git
cd api-equipment
```

#### Develop

Run the application from the command line using:
```
mvn spring-boot:run
```

## API Documentation

http://localhost:8080/swagger-ui.html

## Explore Rest APIs

Namespace     |   URL                        | HTTP Verb        | Result 
--------------|----------------------------- | ---------------- | -------------------------
Equipamentos  | /api/v1/equipamento          | POST             | Add equipamento
Equipamentos  | /api/v1/equipamento        | GET              | Return all equipamentos
Equipamentos  | /api/v1/equipamento/:id    | GET              | Return equipamento by ID
Equipamentos  | /api/v1/equipamento/:id    | DELETE           | Remove equipamento

You can test them using postman or any other rest client.
