This is the most important part of the assignment:

Type	Class	Meaning
Command	CreateOrderCommand	Request an action
Event	OrderCreatedEvent	Notify that something happened
Document	OrderDocument	Carry complete data
Query	GetInventoryAvailability	Request information


                    ORDER SYSTEM

CreateOrderCommand
"Create an order"
        │
        ▼
   Order Created
        │
        ▼
OrderCreatedEvent
"Order was created"
        │
        ▼
OrderDocument
"Here is the order data"


GetInventoryAvailability
"Is Laptop available?"
        │
        ▼
     Inventory
        │
        ▼
     Response


     "I created four message classes using
      Java Records to represent different 
      messaging patterns. CreateOrderCommand 
      represents an instruction to create an 
      order, OrderCreatedEvent represents a 
      completed action, OrderDocument carries 
      order information, and GetInventoryAvailability 
      represents a query for inventory 
      information."