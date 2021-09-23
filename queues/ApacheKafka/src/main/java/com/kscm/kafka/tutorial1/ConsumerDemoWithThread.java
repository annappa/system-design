package com.kscm.kafka.tutorial1;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerDemoWithThread {
    public static void main(String[] args) {
        new ConsumerDemoWithThread().run();
    }

    private ConsumerDemoWithThread() {

    }

    private void run() {
        Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThread.class.getName());

        String bootstrapServers = "127.0.0.1:9092";
        String groupId = "my-ninth-application";
        String topic = "first_topic";

        //latch for dealing with multiple threads
        CountDownLatch latch = new CountDownLatch(1);

        logger.info("Creating the consumer thread");
        Runnable myConsumerRunnable = new ConsumerRunnable(latch, bootstrapServers, groupId, topic );

        Thread myThread = new Thread(myConsumerRunnable);
        //start the thread
        myThread.start();

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            logger.info("Caught shutdown hook");
            ((ConsumerRunnable)myConsumerRunnable).shutdown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Application has exited");
        }
        ));

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Application got interrupted", e);
        } finally {
            logger.info("Application is closing");
        }
    }

    public class ConsumerRunnable implements Runnable {
        private Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class.getName());
        private CountDownLatch latch;
        KafkaConsumer<String, String> consumer;

        public ConsumerRunnable(CountDownLatch latch,
                                String bootstrapServers,
                                String groupId,
                                String topic) {
            this.latch = latch;

            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest --> from the beginning, latest --> only new message

            //create a consumer
            consumer = new KafkaConsumer<String, String>(properties);

            //subscribe consumer to our topics
            consumer.subscribe(Arrays.asList(topic));

        }

        @Override
        public void run() {
            //poll for new data
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

                    for (ConsumerRecord<String, String> record : records) {
                        logger.info("Key: " + record.key() + ", Value: " + record.value());
                        logger.info("Partition: " + record.partition() + ", Offset: " + record.offset());
                    }
                }
            } catch(WakeupException ex) {
                logger.info("Received shutdown signal!");
            } finally {
                consumer.close();
                // tell our main code we are done with the consumer
                latch.countDown();
            }
        }

        public void shutdown() {
            //the wakeup() method is a special method to interrupt consumer.poll()
            //it will throw the exception WakeUpException
            consumer.wakeup();
        }
    }
}
