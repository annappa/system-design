## Info and Docs
[Apache Kafka Essential Training by Kumaran Ponnambalam](https://www.linkedin.com/learning/apache-kafka-essential-training-getting-started/getting-started-with-apache-kafka?u=42751868)

[Kafka Clients](https://docs.confluent.io/platform/current/clients/index.html)

[learn-apache-kafka-for-beginners by Stephane Maarek](https://www.linkedin.com/learning/learn-apache-kafka-for-beginners/apache-kafka-in-five-minutes?u=42751868)

[Kafka Documentation](https://kafka.apache.org/documentation/)

[kafka-beginners-course by Stephane Maarek](https://github.com/simplesteph/kafka-beginners-course)

## Before Kafka / Problems Without Kafka
#### Problems Without Kafka
![Problems_Without_Kafka1.png](./Images/Problems_Without_Kafka1.png)

----

![Problems_Without_Kafka2.png](./Images/Problems_Without_Kafka2.png)

----

#### Why Apache Kafka? 
![Why_Apache_Kafka1.png](./Images/Why_Apache_Kafka1.png)

----
![Why_Apache_Kafka2.png](./Images/Why_Apache_Kafka2.png)

----
![Why_Apache_Kafka3.png](./Images/Why_Apache_Kafka3.png)

-----

#### Apache Kafka Use Cases
![Apache_Kafka_Use Cases.png](./Images/Apache_Kafka_Use Cases.png)

----

#### Apache Kafka Examples
![Apache_Kafka_Examples.png](./Images/Apache_Kafka_Examples.png)


## Topics , Partitions and Offsets
![Topics_Partitions _Offset.png](./Images/Topics_Partitions%20_Offset.png)

## Topics Example: truck_gps
![Topic_Example_truck_gps.png](./Images/Topic_Example_truck_gps.png)

## Topics , Partitions and Offsets Summary
![Topics_Partitions_Offsets_Summary.png](./Images/Topics_Partitions_Offsets_Summary.png)

## Brokers
![Brokers.png](./Images/Brokers.png)

## Brokers and Topics
![Brokers_and_Topics.png](./Images/Brokers_and_Topics.png)

## Topic Replication Factor
![Topic_Replication_Factor1.png](./Images/Topic_Replication_Factor1.png)

----

![Topic_Replication_Factor2.png](./Images/Topic_Replication_Factor2.png)

## Concept Of Leader For A Partition
![Concept_Of_Leader_For_A_Partition.png](./Images/Concept_Of_Leader_For_A_Partition.png)

## Producers
![Producers1.png](./Images/Producers1.png)

----
![Producers2.png](./Images/Producers2.png)

----
![Producers3.png](./Images/Producers3.png)

## Consumers
![Consumers1.png](./Images/Consumers1.png)

----
![Consumers_Groups.png](./Images/Consumers_Groups.png)

----
![Consumers_Groups_What_If_more_consumers_than_partions.png](./Images/Consumers_Groups_What_If_more_consumers_than_partions.png)

## Consumer Offsets
![Consumer_Offsets.png](./Images/Consumer_Offsets.png)

#### Delivery Semantics for Consumers
![Delivery_semantics_for_Consumers.png](./Images/Delivery_semantics_for_Consumers.png)

## Kafka Broker Discovery
![Kafka_Broker_Discovery.png](./Images/Kafka_Broker_Discovery.png)

## Zookeeper
![Zookeeper.png](./Images/Zookeeper.png)


![Zookeeper2.png](./Images/Zookeeper2.png)

## Kafka Guarantees
![Kafka_Guarantees.png](./Images/Kafka_Guarantees.png)

## Kafka Theory Summary
![Kafka_Theaory_Summary.png](./Images/Kafka_Theaory_Summary.png)

## Kafka Setup
####MacOS
[Kafka Downloads](https://kafka.apache.org/downloads) --> For binary download
Set this your PATH. 

```shell script
$ brew install kafka

$ kafka-topics 
   Run this command to verify whether installation is successful

$ cd /Users/annappar/OraDocs/AconexMac/Softwares/kafka_2.13-2.8.0
  Kafka binary is here. We will use few configs from this location

$ zookeeper-server-start ./config/zookeeper.properties

$ cat ./config/zookeeper.properties | grep data
  > dataDir=/Users/annappar/OraDocs/AconexMac/Softwares/kafka_2.13-2.8.0/data/zookeeper

$ cat ./config/server.properties| grep "log.dirs"
  > log.dirs=/Users/annappar/OraDocs/AconexMac/Softwares/kafka_2.13-2.8.0/data/kafka

$ kafka-server-start config/server.properties
```

## Kafka CLI
#### Kafka topics CLI
```shell script
$ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --create
 > This will fail -> Missing required argument "[partitions]"

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3
  > This will fail again > Missing required argument "[replication-factor]"

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 2
  > This will fail again
  > Error while executing topic command : Replication factor: 2 larger than available brokers: 1
  > We can nt give replica count less than the number of available brokers

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 1
  > This will be successful

$ kafka-topics --zookeeper 127.0.0.1:2181 --list

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic first_topic --describe

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic second_topic --create --partitions 3 --replication-factor 1

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic second_topic --delete

$ kafka-topics --zookeeper 127.0.0.1:2181 --list
```

#### Kafka console producer CLI
````shell script
$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic
  >hello Annappa
  >awesome course!
  >learning kafka
  >just another message :)
 press ctrl+c to end producing messages

$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic --producer-property acks=all

$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic new_topic  
  > This will create the new topic as new_topic does not exist

$ kafka-topics --zookeeper 127.0.0.1:2181 --list

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic new_topic --describe

$ cat ./config/server.properties| grep "num.partitions"
  num.partitions=1
  > This means, by default , when topic is created, only one partition will be created

$ vi ./config/server.properties 
  > change the default partitions value from 1 to 3. Stop kafka server and start it,

$ kafka-server-start config/server.properties

$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic new_topic_2

$ kafka-topics --zookeeper 127.0.0.1:2181 --list

$ kafka-topics --zookeeper 127.0.0.1:2181 --topic new_topic_2 --describe
````

#### Kafka console consumer CLI
```shell script
$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic
  > This will read only the new messages. 
  > U can test it by running the producer and producing few messages to the topic

$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning
  > This will read the messages from the beginning
```

#### #### Kafka console consumer group CLI
Start two consumers with the same group and one producer to the topic - **first_topic**
```shell script
$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic

Here 2 consumers are there to read it from 2 partitions.
```

Start 3 consumers with the same group and one producer to the topic - **first_topic**

```shell script
$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

$ kafka-console-producer --broker-list 127.0.0.1:9092 --topic first_topic

Here 3 consumers are there to read it from 3 partitions. Load will be equally distributed
```

If you stop one consumer out of 3, load will be rebalanced between 2 consumers ..

Now stop all consumers. and start the below one with bew group

```shell script
$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-second-application --from-beginning
  > This will read all the messages from the beginning and sets the offset
```

Now stop the above consumer and re-run again.
```shell script
$ kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-second-application --from-beginning
  No old messages read as all the messages were read by this group in the previous run. But it can read the newly arriving messages
```

## kafka-consumer-groups
```shell script
$ kafka-consumer-groups --bootstrap-server localhost:9092 --list

$ kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group my-second-application
```

## Resetting offset

## Kafka Java Programming
[ProducerDemo.java](./src/main/java/com/kscm/kafka/ProducerDemo.java)

[ProducerDemoWithCallback.java](./src/main/java/com/kscm/kafka/ProducerDemoWithCallback.java)

[ProducerDemoKeys.java](./src/main/java/com/kscm/kafka/ProducerDemoKeys.java)

[ConsumerDemo.java](./src/main/java/com/kscm/kafka/ConsumerDemo.java)

##### Run the below ConsumerDemoGroups.java multiple times(multiple consumers in a group) and start a producer and observe how rebalancing happens
[ConsumerDemoGroups.java](./src/main/java/com/kscm/kafka/ConsumerDemoGroups.java)

[ConsumerDemoAssignSeek](./src/main/java/com/kscm/kafka/tutorial1/ConsumerDemoAssignSeek.java)

## Twitter Producer Example

[TwitterProducer](./src/main/java/com/kscm/kafka/tutorial2/TwitterProducer.java)

## Producers Acks Deep Dive 
#### acks=0 (no acks) 
![producer_ack0.png](./Images/producer_ack0.png)

#### acks=1 (Leader acks)

![producer_acks1_leader_acks.png](./Images/producer_acks1_leader_acks.png)

#### acks=all (replicas acks)
![producer_all_acks_replicas_acks.png](./Images/producer_all_acks_replicas_acks.png)

----
![producer_all_acks_replicas_acks_2.png](./Images/producer_all_acks_replicas_acks_2.png)

----
![producer_all_acks_replicas_acks_3.png](./Images/producer_all_acks_replicas_acks_3.png)

## Retries by producer

## Idempotent Producer

## Delivery semantics for consumers

## Consumer - Idempotence

## Consumer - Poll Behaviour

## Consumer Offset Commis Strategy

## Kafka Connect

## Kafka Streams for filtering data

## Kafka Schema registry for data /message verification/validation 

## Kafka Partition count intuition / Guidelines

## Replication Factor intuition / Guidelines

## Cluster Guidelines

## Case Studies
#### MovieFlex Architecture using Kafka
![MovieFlex Requirements.png](./Images/MovieFlex Requirements.png)

----
![MovieFlex Architecture Using Kafka.png](./Images/MovieFlex Architecture Using Kafka.png)

----
![MovieFlex Architecture Using Kafka_Guideline.png](./Images/MovieFlex Architecture Using Kafka_Guideline.png)

#### GetTaxi 
![GetTaxi Requirements.png](./Images/GetTaxi Requirements.png)

----
![GetTaxi Architecture Using Kafka.png](./Images/GetTaxi Architecture Using Kafka.png)

----
![GetTaxi Architecture Using Kafka_Guideline.png](./Images/GetTaxi Architecture Using Kafka_Guideline.png)

#### CQRS(Command Query Responsibility Segregation) - MySocialMedia
![MySocialMedia_Requirements.png](./Images/MySocialMedia_Requirements.png)

----
![MySocialMedia_System_Design.png](./Images/MySocialMedia_System_Design.png)

----
![MySocialMedia_Guidelines.png](./Images/MySocialMedia_Guidelines.png)

#### Finance Application MyBank
![Finance_App_MyBank_Requirements.png](./Images/Finance_App_MyBank_Requirements.png)

----
![Finance_App_MyBank_System_Design_Using_Kafka.png](./Images/Finance_App_MyBank_System_Design_Using_Kafka.png)

----
![Finance_App_MyBank_Guidelines.png](./Images/Finance_App_MyBank_Guidelines.png)

## Big Data Ingestion

## Logging and Monitoring Using Kafka
![Logging_Monitoring_Using_Kafka.png](./Images/Logging_Monitoring_Using_Kafka.png)

## Authentication in Kafka

## Encryption in Kafka

## Authorization in kafka