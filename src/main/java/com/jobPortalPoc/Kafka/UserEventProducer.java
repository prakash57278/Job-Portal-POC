package com.jobPortalPoc.Kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserEventProducer {

    private final KafkaTemplate<String, UserDocument> kafkaTemplate;

    public void publishUser(UserDocument userDocument) {
        kafkaTemplate.send("user-events", userDocument);
    }
}