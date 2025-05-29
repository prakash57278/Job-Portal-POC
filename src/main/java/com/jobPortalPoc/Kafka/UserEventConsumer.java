package com.jobPortalPoc.Kafka;


import com.jobPortalPoc.Repository.UserDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventConsumer {

    private final UserDocumentRepository userDocumentRepository;

    @KafkaListener(topics = "user-events", groupId = "user-indexer", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(UserDocument userDocument) {
        System.out.println("Received from Kafka: " + userDocument.getFullName());
        userDocumentRepository.save(userDocument);
    }
}
