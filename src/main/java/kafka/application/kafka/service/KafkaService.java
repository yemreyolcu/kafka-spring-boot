package kafka.application.kafka.service;

import kafka.application.kafka.kafka.MessageConsumer;
import kafka.application.kafka.kafka.MessageProducer;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final MessageProducer producer;
    private final MessageConsumer consumer;

    public KafkaService(MessageProducer producer, MessageConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void sendMessage(Object product) {
        producer.sendMessage(product);
    }

    public void listen(Object message) {
        consumer.listen(message);
    }
}
