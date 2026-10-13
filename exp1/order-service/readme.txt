                    POST / GET / PUT / DELETE
                              │
                              ▼
                    ┌───────────────────┐
                    │  OrderController  │
                    │ Presentation/API  │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │   OrderService    │
                    │ Application Layer │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │  OrderRepository  │
                    │    Data Layer     │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │    H2 Database    │
                    └───────────────────┘



           Open Postman.

Choose:

POST

URL:

http://localhost:8080/orders

Go to:

Body → raw → JSON

Send:

{
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000
}

Click Send.

You should get something like:

{
    "id": 1,
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000.0
}

🎉 You just inserted your first order into the database.

STEP 11 — GET All Orders

In Postman:

GET
http://localhost:8080/orders

Click Send.

You should get:

[
    {
        "id": 1,
        "customerName": "Keerthi",
        "productName": "Laptop",
        "quantity": 2,
        "price": 55000.0
    }
]
STEP 12 — GET One Order

Use:

GET http://localhost:8080/orders/1

Response:

{
    "id": 1,
    "customerName": "Keerthi",
    "productName": "Laptop",
    "quantity": 2,
    "price": 55000.0
}
STEP 13 — UPDATE

Use:

PUT http://localhost:8080/orders/1

Body:

{
    "customerName": "Keerthi",
    "productName": "Gaming Laptop",
    "quantity": 1,
    "price": 75000
}

You'll get the updated order.

STEP 14 — DELETE

Use:

DELETE http://localhost:8080/orders/1

You should receive:

204 No Content