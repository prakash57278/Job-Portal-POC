package com.jobPortalPoc.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private String location;
    private String resumeUrl;
    private String profileSummary;
    private List<String> skills;

    // Getters and setters omitted for brevity
}
