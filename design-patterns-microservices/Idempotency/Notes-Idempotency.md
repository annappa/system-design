🔁 3. Idempotency
Definition:

An operation is idempotent if running it multiple times produces the same result as running it once.

Why needed?

Because retries can cause duplicate operations.

Examples:

GET → always idempotent

PUT → sets a known state → idempotent

DELETE → multiple deletes = same state → idempotent

POST → not idempotent by default
(creates duplicates)

How to make POST idempotent?

Use an idempotency key:

POST /payments
Idempotency-Key: 12345


If the same key is seen again → server returns same result, doesn’t create duplicate payments.