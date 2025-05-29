package com.jobPortalPoc.Kafka;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "users")
public class UserDocument {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private String location;
    private String resumeUrl;
    private String profileSummary;
    private List<String> skills;
}
