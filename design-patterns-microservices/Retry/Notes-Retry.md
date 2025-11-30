✅ 1. Retry Pattern
What it is:

Retry a failed operation automatically when the failure is temporary (network glitches, high latency, transient errors).

Simple example:

Calling a downstream service that failed due to a momentary connection drop.

Good retries should include:

Exponential backoff
(1 sec, 2 sec, 4 sec…)

Jitter (random delay)
to avoid retry storms

Retry only for transient errors
(don’t retry on 400, validation errors)

Bad retries = cascading failures

So Retry is ALWAYS used with:

Timeout

Circuit Breaker