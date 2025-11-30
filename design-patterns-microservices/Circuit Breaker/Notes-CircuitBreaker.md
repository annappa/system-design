## Info
Goal:

Prevent repeated calls to a failing service to avoid wasting time/resources.

How it works:

If a service keeps failing:

Circuit goes OPEN

Stops all calls temporarily

Returns failure immediately

After a timeout, goes to HALF-OPEN to test the service

If healthy → CLOSED

Analogy:

Electrical fuse — when overloaded, it “opens” and stops current.

Example:

Service B is down → instead of retrying again and again:

Circuit opens

All calls instantly fail

Protects threads & avoids cascade failures

##
📌 Key Difference (Interview-Winning Answer)
Bulkhead:

Protects your service’s resources by isolating them.
(Thread pool isolation)

Circuit Breaker:

Protects your service from calling a failing downstream dependency repeatedly.
(Fail-fast mechanism)