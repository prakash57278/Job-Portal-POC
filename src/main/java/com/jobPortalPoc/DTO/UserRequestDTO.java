package com.jobPortalPoc.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String role; // e.g., "RECRUITER", "JOB_SEEKER"
    private String location;
    private String resumeUrl; // This can be a file upload later, or stored as a URL
    private String profileSummary;
    private List<String> skills;
}
