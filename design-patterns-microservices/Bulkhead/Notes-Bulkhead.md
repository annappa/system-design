## Info
1. Bulkhead Pattern — Resource Isolation
   Goal:

Prevent one failing component from consuming all system resources.

How it works (simple):

Divide your system into isolated pools (threads, connections, memory).
If one pool is overloaded, others keep working.

Analogy:

Ship bulkheads — if one compartment floods, others stay safe.

Example (Java):

Separate thread pools:

Payments → 20 threads

Notifications → 10

Analytics → 5

If Analytics hangs, only its 5 threads get stuck.
System continues normally.\

##
📌 Key Difference (Interview-Winning Answer)
Bulkhead:

Protects your service’s resources by isolating them.
(Thread pool isolation)

Circuit Breaker:

Protects your service from calling a failing downstream dependency repeatedly.
(Fail-fast mechanism)