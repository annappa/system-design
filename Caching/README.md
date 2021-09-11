## Info and Docs
[Cache (computing) - wiki](https://en.wikipedia.org/wiki/Cache_(computing))

[AWS - what is caching](https://aws.amazon.com/caching/)

[Caching strategies](https://docs.aws.amazon.com/AmazonElastiCache/latest/mem-ug/Strategies.html)

[Cache replacement policies](https://en.wikipedia.org/wiki/Cache_replacement_policies)

[All things caching- use cases, benefits, strategies, choosing a caching technology, exploring some popular products](https://medium.datadriveninvestor.com/all-things-caching-use-cases-benefits-strategies-choosing-a-caching-technology-exploring-fa6c1f2e93aa)

## Caching Strategies
#### Cache Aside Caching Strategy
![Cache Aside Strategy.png](./Images/Cache%20Aside%20Strategy.png)

![Cache Aside Strategy Overview.png](./Images/Cache%20Aside%20Strategy%20Overview.png)

####Read Through Caching Strategy
This pattern is common in ORM frameworks like Hibernate

![Read Through Caching Strategy.png](./Images/Read%20Through%20Caching%20Strategy.png)

![Read Through Caching Strategy Overview.png](./Images/Read Through Caching Strategy Overview.png)

#### Write Through Caching Strategy
![Write Through Caching Strategy.png](./Images/Write Through Caching Strategy.png)

![Write Through Caching Strategy Overview.png](./Images/Write%20Through%20Caching%20Strategy%20Overview.png)

Main disadvantage is redundance means this caches the data which might not be read ever.

#### Write Behind Caching Strategy

![Write Behind Caching Strategy.png](./Images/Write%20Behind%20Caching%20Strategy.png)

![Write Behind Caching Strategy Overview.png](./Images/Write%20Behind%20Caching%20Strategy%20Overview.png)

Here cache acts as a buffer. 

## Cache Eviction Policies
#### Most commonly used strategies
- LRU - Least Recently Used
- LFU - Most frequently Used

There are many other eviction policies. 

#### LRU
- LRU is like a linked list. Newly accessed one will be added at the tail and head will be evicted

![LRU1](./Images/LRU1.png)

-----
![LRU2](./Images/LRU2.png)
Accessed Joker here, so it moved to tail
-----

![LRU3](./Images/LRU3.png)

#### LFU
- Here for every cached item, one counter will be maintained. 
- Everytime u access a item in the cache, counter will reset to 0
- While cached item not accessed, its counter will be keep on increasing. Larger counter value one will be eligible for eviction

![LFU.png](./Images/LFU.png)


#### Summary of LRU & LFU.png
![Summary of LRU & LFU.png](./Images/Summary%20of%20LRU%20&%20LFU.png)

## Redis

![Redis.png](./Images/Redis.png)

-----

![Redis Data Types.png](./Images/Redis%20Data%20Types.png)

----
![Redis TTL.png](./Images/Redis%20TTL.png)

-----
![Redis Persistence.png](./Images/Redis%20Persistence.png)

-----
![Redis Summary.png](./Images/Redis%20Summary.png)

