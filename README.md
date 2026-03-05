# Hotel Room Ordering API

Spring Boot API for tea/coffee room-service ordering.

## Run instructions

### Prerequisites
- Java 17+
- Maven 3.9+

### Start the app
```bash
mvn spring-boot:run
```

App runs on `http://localhost:8080`.

### API documentation (Swagger/OpenAPI)
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Seed data
On startup, menu is preloaded from `data.sql`:
- `TEA` — Masala Tea — 2.50
- `COFFEE` — Americano Coffee — 3.00

## API examples (curl)

### Get menu
```bash
curl -s http://localhost:8080/api/menu
```

### Place tea order
```bash
curl -s -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "menuCode": "TEA",
    "roomNumber": "1208",
    "quantity": 2
  }'
```

### Place coffee order
```bash
curl -s -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "menuCode": "COFFEE",
    "roomNumber": "515",
    "quantity": 1
  }'
```

### Validation error example
```bash
curl -s -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "menuCode": "",
    "roomNumber": "",
    "quantity": 0
  }'
```

## Sample payloads

### Tea order payload
```json
{
  "menuCode": "TEA",
  "roomNumber": "1208",
  "quantity": 2
}
```

### Coffee order payload
```json
{
  "menuCode": "COFFEE",
  "roomNumber": "515",
  "quantity": 1
}
```

## Status flow and assumptions

### Status flow
1. `PLACED` — order accepted and recorded.
2. `PREPARING` — drink is being prepared (future state for kitchen workflow).
3. `DELIVERED` — drink delivered to room (future state for delivery workflow).

Current implementation creates new orders with status `PLACED`.

### Assumptions
- Only tea and coffee are available initially through startup seed data.
- Room number is a free-form string validated as non-empty.
- Quantity must be at least `1`.
- Total price = menu item price × quantity.
- Error responses are standardized through `GlobalExceptionHandler`.
