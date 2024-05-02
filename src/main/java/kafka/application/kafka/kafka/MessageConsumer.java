package kafka.application.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "product", groupId = "group_id")
    public void listen(Object message) {
        System.out.println("Received Message in group foo: " + message);
    }


}
