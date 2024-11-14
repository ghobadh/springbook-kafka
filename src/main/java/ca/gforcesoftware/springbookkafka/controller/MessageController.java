package ca.gforcesoftware.springbookkafka.controller;

import ca.gforcesoftware.springbookkafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gavinhashemi on 2024-11-14
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        kafkaProducer.send(topicName, message);
        return ResponseEntity.ok(message);
    }
}
