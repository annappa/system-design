⏳ 2. Timeout Pattern
What it is:

Limit how long you wait for a response.

Without timeouts, a request may hang forever → thread starvation.

Example:

If you call a service and it doesn’t respond within 200ms:

throw TimeoutException

Timeout + Retry = Perfect Pair

Timeout protects your threads.
Retry gives another chance.