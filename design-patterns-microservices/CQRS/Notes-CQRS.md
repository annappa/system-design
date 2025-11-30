🧭 4. CQRS (Command Query Responsibility Segregation)
Simple definition:

Separate read and write models.

Commands (write model) → update DB

Queries (read model) → read from optimized DB / cache / index

Why?

Scale reads and writes differently

Reads are far more frequent

Allows using different databases
(e.g., writes → SQL, reads → Elasticsearch)

Example:

E-commerce:

Writing order data → PostgreSQL

Reading product catalog → Elasticsearch

Lucene indexing (which you mentioned earlier) is indeed part of CQRS’s read model.