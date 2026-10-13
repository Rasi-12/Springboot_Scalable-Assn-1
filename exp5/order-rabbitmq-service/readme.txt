Postman
   ↓
OrderController
   ↓
OrderService
   ↓
H2 Database
   ↓
OrderCreatedEvent
   ↓
RabbitTemplate
   ↓
JSON Converter
   ↓
RabbitMQ Exchange
   ↓
Routing Key: order.created
   ↓
order.created.queue

Use:

POST http://localhost:8081/orders

Body → raw → JSON:

{
    "customerId": 5001,
    "productName": "Laptop",
    "quantity": 2,
    "amount": 75000
}

Click Send.

You should now get:

{
    "id": 2,
    "customerId": 5001,
    "productName": "Laptop",
    "quantity": 2,
    "amount": 75000.0
}

The ID might be 2 rather than 1 because your 
previous request already inserted the order into
 H2 before RabbitMQ failed. Your log confirms the 
 SQL insert happened before the conversion error