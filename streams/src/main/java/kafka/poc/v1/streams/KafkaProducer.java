package kafka.poc.v1.streams;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("input-topic", message)
                .addCallback(
                        result -> System.out.println("Message sent to topic: " + message),
                        ex -> System.out.println("Failed to send message: " + ex)
                );
    }
}