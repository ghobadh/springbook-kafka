### Codecov.io
* Add JACOCO to the pom.xml as plugin
* Add ci.yml under .github\workflows
* Add orbs to config.yml under .circleci

****

Status in building the project in Cricle Ci :  [![CircleCI](https://dl.circleci.com/status-badge/img/gh/ghobadh/springboot-kafka/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/ghobadh/springboot-kafka/tree/master)
****
Code Coverage Percentage :[![codecov](https://codecov.io/gh/ghobadh/springboot-kafka/graph/badge.svg?token=PRFWMSQQH5)](https://codecov.io/gh/ghobadh/springboot-kafka)



# Kafka
Apache Kafka is an open-source distributed event streaming platform used by many companies for high performance data pipeline
, streaming analytics, data integration, and mission-critical applications.

### Cluster
Since Kafka is a distributed system, it acts as a cluster. A Kafka Cluster consists of a set of broker.
It is container of Kafka Broker. Each cluster has to keep minimum three brokers.

### Broker
It is basically Kafka Server. It's jsut a meaningful name given to the Kafka server and this name makes sense as well
because all that Kafka does is act as a message broker b/c producer and consumer. The producer and consumer do not interact directly. They use Kafka server as an agent or
a broker to change message

### Producer
Producer is an application that sends messages. It does not send messages directly to the recipient. It sends messages only to the Kafka server.

### Consumer
Consumer is an application that reads messages from the Kafka server. If producers are sending data, they must be sending it to someone, right? The consumer are the
recipients. but remember that the producers don't send data to a recipient directly. They just send to Kafka server. and anyone who is interested in the data can come forward and take it from
Kafka server. So, any application that requests data from a Kafka server is a consumer, and they can ask for data sent by any producer provided they have permission to read it.

### Kafka Topic
Topic is for identification mechanism to request data from a broker. There commes the notion of the topic
* Topic is like a table in database or folder in a file system
* Topic is identified by a name
* You can have any number of Topics


### Kafka Partitions
Kafka topics are divided into a number of partitions, which is contain records in an unchangeable sequence.
Kafka broker will store messages for a topic, but the capacity of data can be enormous and it may not be possible to store
in a single computer. Therefore, it will paritioned into multiple parts and distributed among multiple computers, since
Kafka is a distributed system.


Several portions --> one topic
Several topics --> one broker
Several brokers --> one cluster

### Offsets
Offsets is a sequence of ids given to messages as the arrive at a partition. Once the offset is assigned
it will never be changed. The first message gets an offset zero, The next message receives an offset
one and so on.

### Consumer Group
A consumer group contains one or more consumers working together to process the messages.

### Zookeeper
It is managing all brokers in the cluster and all push and pull messages to the cluster.


### Spring for Kafka
[https://docs.spring.io/spring-kafka/reference/quick-tour.html](https://docs.spring.io/spring-kafka/reference/quick-tour.html)


#### How to Set up Kafka in Spring

#Kafka Consumer Setup
spring.kafka.consumer.bootstrap-servers=192.168.23.47:9092
spring.kafka.consumer.group-id=gForceGroup
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer

#Kafka Producer Setup
spring.kafka.producer.bootstrap-servers=192.168.23.47:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringDeserializer

### How to Run Kafka in Docker
* Use this YAML file with name docker-compose.yml (IP address has to change in plain text host line)
```
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - 22181:2181
  
  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 29092:29092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://192.168.23.47:29092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

```

* run the docker as this command (with space rather than '-')
  ``` sudo docker compose up -d```

* To shutdown you run this command ```sudo docker compose down```

## Serialization and Deserializatin JSON on Kafka
### How to send and receive a Java Object as a JSON byte [] to and from Apache Kafka
Apache Kafka stores and transports byte[] . There are number of built-in serializer and deserializer but
it does't include any for JSON. Spring Kafka created a JsonSerializer and JsonDeserializer which we can use to
convert Java Object to and from JSON.

We'll send a Java object as JSON byte[] to a Kafka topic using a `JsonSerializer`. After that, we'll configure how to
receive a JSON byte[] and automatically convert it to a Java Object using a `JsonDeserializer`.
