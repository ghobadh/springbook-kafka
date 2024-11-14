package ca.gforcesoftware.springbookkafka.kafka;

import ca.gforcesoftware.springbookkafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Slf4j
@Service
public class JsonKafkaConsumer {

    @Value("${spring.kafka.topic-json.name}")
    private String topicName;

    @KafkaListener(topics =  "${spring.kafka.topic-json.name}", groupId = "gForceGroup")
    public void jSonConsume(User userMessage) {
        log.info("JSON consumer Message -->{} from {} Kafka Topic." , userMessage.toString() ,  topicName);
    }
}
