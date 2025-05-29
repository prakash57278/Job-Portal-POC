package com.jobPortalPoc.Repository;


import com.jobPortalPoc.Kafka.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {
}
