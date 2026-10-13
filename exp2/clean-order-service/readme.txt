Your complete architecture

Now your application looks like this:

                         CLIENT / POSTMAN
                               │
                               ▼
                    ┌────────────────────┐
                    │   OrderController  │
                    │     API Adapter    │
                    └─────────┬──────────┘
                              │
                              ▼
                    ┌────────────────────┐
                    │   OrderUseCase     │
                    │    INPUT PORT      │
                    └─────────┬──────────┘
                              │
                              ▼
                    ┌────────────────────┐
                    │   OrderService     │
                    │   APPLICATION      │
                    └──────┬─────┬───────┘
                           │     │
                  OUTPUT PORT    │
                           │     │
                           ▼     ▼
                ┌─────────────┐  ┌─────────────────┐
                │ Repository  │  │ Messaging Port  │
                │    Port     │  │                 │
                └──────┬──────┘  └────────┬────────┘
                       │                  │
                       ▼                  ▼
             ┌──────────────────┐  ┌─────────────────┐
             │ Persistence      │  │ Messaging       │
             │ Adapter          │  │ Adapter         │
             └────────┬─────────┘  └─────────────────┘
                      │
                      ▼
             ┌──────────────────┐
             │ Spring Data JPA  │
             └────────┬─────────┘
                      │
                      ▼
                 H2 DATABASE
17. Run the application

Run:

CleanOrderServiceApplication.java

You should see:

Started CleanOrderServiceApplication

and:

Tomcat started on port 8080

If you get this, we're good.

18. Test with Postman

Now let's actually prove the microservice works.

Test 1 — CREATE ORDER

Select:

POST

URL:

http://localhost:8080/orders

Go to:

Body
→ raw
→ JSON

Send:

{
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000
}

Expected response:

{
    "id": 1,
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000.0
}

And in your IntelliJ/VS Code console:

MESSAGE EVENT: Order created - Order ID: 1, Customer: Keerthi

🔥 This proves both persistence + messaging adapter are working.

19. GET all orders

Postman:

GET
http://localhost:8080/orders

Expected:

[
    {
        "id": 1,
        "customerName": "Keerthi",
        "productName": "Laptop",
        "quantity": 2,
        "price": 55000.0
    }
]
20. GET one order
GET
http://localhost:8080/orders/1

Expected:

{
    "id": 1,
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000.0
}
21. UPDATE order

Use:

PUT
http://localhost:8080/orders/1

Body:

{
    "customerName": "Keerthi",
    "productName": "Gaming Laptop",
    "quantity": 1,
    "price": 75000
}

Expected:

{
    "id": 1,
    "customerName": "Keerthi",
    "productName": "Gaming Laptop",
    "quantity": 1,
    "price": 75000.0
}
22. DELETE order

Use:

DELETE
http://localhost:8080/orders/1

Expected:

204 No Content
23. Test that the domain logic works

Create another order with:

{
    "customerName": "Test User",
    "productName": "Keyboard",
    "quantity": 0,
    "price": 2000
}

Send:

POST /orders

The service checks:

if (order.getQuantity() <= 0)

and rejects it.

I developed an Order microservice using Clean 
Architecture, separating the domain and 
application logic from infrastructure 
through input and output ports, with 
adapters for REST API, JPA persistence, 
and messaging