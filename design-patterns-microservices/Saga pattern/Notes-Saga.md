🔄 5. Saga Pattern (For Distributed Transactions)

Used when one transaction spans multiple microservices, and a normal ACID transaction is impossible.

Two types:

Choreography Saga

No orchestrator

Services publish events

Other services react

Good for simple workflows

Orchestration Saga

One central coordinator

Calls each service in order

If anything fails → triggers compensating transactions

Example: Placing an order

Reserve inventory

Deduct payment

Create shipment

If payment fails → reverse inventory reservation.