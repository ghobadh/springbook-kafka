package ca.gforcesoftware.springbookkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic-json.name}")
    String topicJsonName;

    @Value("${spring.kafka.topic.name}")
    String topicName;

    @Bean
    public NewTopic stringTopic() {
        return TopicBuilder.name(topicName)
                .build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
