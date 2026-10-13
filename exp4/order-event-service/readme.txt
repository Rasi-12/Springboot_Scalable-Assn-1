It contains exactly what the assignment asks for:

Field	Purpose
eventId	Unique ID of this event
correlationId	Links this event to the overall request/transaction flow
orderId	Identifies the created order
customerId	Identifies the customer
amount	Order amount
timestamp	When the event occurred

# OrderCreatedEvent Payload

## Objective

Create and implement an `OrderCreatedEvent` payload containing an event ID, correlation ID, order ID, customer ID, amount, and timestamp using Java and Spring Boot.

## Technologies Used

* Java 17
* Spring Boot
* Maven
* Spring Web
* Java Records
* Postman

## Project Structure

```text
order-event-service
│
├── src
│   └── main
│       └── java
│           └── com.example.ordereventservice
│               │
│               ├── OrderEventServiceApplication.java
│               │
│               └── event
│                   ├── OrderCreatedEvent.java
│                   └── OrderEventController.java
│
├── pom.xml
└── README.md
```

## Event Payload

The `OrderCreatedEvent` is implemented using a Java Record.

```java
public record OrderCreatedEvent(
        UUID eventId,
        UUID correlationId,
        Long orderId,
        Long customerId,
        double amount,
        LocalDateTime timestamp
) {
}
```

### Payload Fields

| Field           | Description                                 |
| --------------- | ------------------------------------------- |
| `eventId`       | Unique identifier for the event             |
| `correlationId` | Identifier used to trace related operations |
| `orderId`       | Unique identifier of the order              |
| `customerId`    | Unique identifier of the customer           |
| `amount`        | Total order amount                          |
| `timestamp`     | Date and time when the event was created    |

## REST API

A REST endpoint is provided to create and demonstrate the `OrderCreatedEvent` payload.

### Endpoint

```text
POST /events/order-created
```

### URL

```text
http://localhost:8080/events/order-created
```

### Request Body

```json
{
    "orderId": 101,
    "customerId": 5001,
    "amount": 75000
}
```

### Expected Response

```json
{
    "eventId": "generated-uuid",
    "correlationId": "generated-uuid",
    "orderId": 101,
    "customerId": 5001,
    "amount": 75000.0,
    "timestamp": "2026-08-14T01:00:00"
}
```

The `eventId`, `correlationId`, and `timestamp` are generated automatically by the application.

## Postman Testing

### 1. Start the Application

Run the Spring Boot application.

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

### 2. Create Order Created Event

**Method:**

```text
POST
```

**URL:**

```text
http://localhost:8080/events/order-created
```

**Header:**

```text
Content-Type: application/json
```

**Body:**

```json
{
    "orderId": 101,
    "customerId": 5001,
    "amount": 75000
}
```

### 3. Expected Result

The API returns the complete `OrderCreatedEvent` payload:

```json
{
    "eventId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
    "correlationId": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
    "orderId": 101,
    "customerId": 5001,
    "amount": 75000.0,
    "timestamp": "2026-08-14T01:00:00"
}
```

## Execution Flow

```text
Postman
   |
   | POST /events/order-created
   ↓
OrderEventController
   |
   ↓
CreateOrderEventRequest
   |
   ↓
OrderCreatedEvent
   |
   ↓
JSON Response
```

## Result

The `OrderCreatedEvent` payload was successfully implemented using Java Records and Spring Boot. The event contains the required event ID, correlation ID, order ID, customer ID, amount, and timestamp, and was successfully tested through a REST API using Postman.
