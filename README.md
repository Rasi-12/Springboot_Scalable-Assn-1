# springboot-microservices-experiments

Spring Boot Microservices – Unit 3

This repository contains 5 Spring Boot microservice experiments covering layered architecture, Clean Architecture, message-based communication, event payloads, and RabbitMQ event publishing.

Experiments
1. Develop a Three-Tier Microservice Application

Implemented a simple Order Service using a three-tier architecture:

Presentation Layer – REST Controller
Application/Service Layer – Business logic
Data Layer – JPA Repository and H2 Database

Technologies: Spring Boot, REST API, JPA, H2, Postman

2. Develop a Microservice Using Clean Architecture

Implemented an Order microservice following Clean Architecture principles by separating:

Domain logic
Application/use-case logic
API adapters
Persistence adapters
Infrastructure components

Technologies: Spring Boot, Java, Clean Architecture, JPA

3. Create Command, Event, Document, and Query Message Classes

Created structured message classes for different types of communication:

CreateOrderCommand
OrderCreatedEvent
OrderDocument
GetInventoryAvailability

These were implemented using Java Records / POJOs.

Technologies: Java, Spring Boot, Java Records

4. Create an OrderCreatedEvent Payload

Created an OrderCreatedEvent payload containing:

Event ID
Correlation ID
Order ID
Customer ID
Amount
Timestamp

The event payload was tested through a REST API and verified using Postman.

Technologies: Java, Spring Boot, REST API, Postman

5. Publish an Event from Order Service

Extended the Order Service to publish an OrderCreatedEvent to RabbitMQ after validating and saving an order.

Flow:

Client
   ↓
Order Controller
   ↓
Validate & Save Order
   ↓
Create OrderCreatedEvent
   ↓
RabbitTemplate
   ↓
RabbitMQ Exchange
   ↓
Routing Key: order.created
   ↓
order.created.queue

Technologies: Spring Boot, RabbitMQ, Spring AMQP, JPA, H2, Postman

Overall Flow
Three-Tier Architecture
        ↓
Clean Architecture
        ↓
Message Classes
        ↓
OrderCreatedEvent Payload
        ↓
RabbitMQ Event Publishing
Technologies Used
Java
Spring Boot
REST API
Spring Data JPA
H2 Database
Java Records / POJOs
RabbitMQ
Spring AMQP
Postman
Maven
VS Code
Testing

The REST APIs were tested using Postman.
For the RabbitMQ experiment, the published OrderCreatedEvent was verified through the configured RabbitMQ exchange and queue.

Project Structure
springboot-microservices-unit3/
│
├── exp1-three-tier/
├── exp2-clean-architecture/
├── exp3-message-classes/
├── exp4-order-event/
├── exp5-order-rabbitmq-service/
│
└── README.md
Result

All five experiments demonstrate the development of Spring Boot microservices from basic layered architecture to event-driven communication using RabbitMQ.
