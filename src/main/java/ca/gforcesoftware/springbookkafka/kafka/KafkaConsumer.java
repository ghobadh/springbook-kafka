package ca.gforcesoftware.springbookkafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "gForceGroup")
    public void consume(String consumeMessage) {
        log.info("Message -->" + consumeMessage );


    }
}
