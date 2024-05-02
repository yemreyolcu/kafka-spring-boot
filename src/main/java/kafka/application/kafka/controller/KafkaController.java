package kafka.application.kafka.controller;

import kafka.application.kafka.dto.ProductDto;
import kafka.application.kafka.kafka.MessageProducer;
import kafka.application.kafka.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final KafkaService service;

    public KafkaController(KafkaService service) {
        this.service = service;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody ProductDto product) {
        service.sendMessage(product);
        return ResponseEntity.ok("Message sent to the Kafka Topic successfully");
    }

    @GetMapping(value = "/consume")
    public ResponseEntity<String> consumeMessageFromKafkaTopic(@RequestParam("message") String message) {
        service.listen(message);
        return ResponseEntity.ok("Message consumed from the Kafka Topic successfully");
    }

}
