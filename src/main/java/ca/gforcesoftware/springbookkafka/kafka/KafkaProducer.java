package ca.gforcesoftware.springbookkafka.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Slf4j
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }



    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
        log.info("Message {} sent to topic {}", message, topic);
    }
}
