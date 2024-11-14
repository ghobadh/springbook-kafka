package ca.gforcesoftware.springbookkafka.kafka;

import ca.gforcesoftware.springbookkafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Slf4j
@Service
public class JsonKafkaProducer {
    @Value("${spring.kafka.topic-json.name}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJson(User user) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,topicName)
                .build();

        log.info("Sending user -->: {}", user.toString());
        kafkaTemplate.send(message);
    }
}
