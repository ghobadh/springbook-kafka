package ca.gforcesoftware.springbookkafka.controller;

import ca.gforcesoftware.springbookkafka.kafka.JsonKafkaProducer;
import ca.gforcesoftware.springbookkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gavinhashemi on 2024-11-14
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/json")
    public ResponseEntity<String> publishMessage(@RequestBody User user) {
        jsonKafkaProducer.sendJson(user);
        return ResponseEntity.ok("{\"user\": \"" + user.toString() + "\"}");

    }
}
