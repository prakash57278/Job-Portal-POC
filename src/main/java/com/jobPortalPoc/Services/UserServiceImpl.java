package com.jobPortalPoc.Services;

import com.jobPortalPoc.DTO.UserRequestDTO;
import com.jobPortalPoc.DTO.UserResponseDTO;
import com.jobPortalPoc.DTO.User;


import com.jobPortalPoc.Kafka.UserDocument;
import com.jobPortalPoc.Kafka.UserEventProducer;
import com.jobPortalPoc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEventProducer userEventProducer;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }




    @Override
    public UserResponseDTO createUser(UserResponseDTO dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setLocation(dto.getLocation());
        user.setResumeUrl(dto.getResumeUrl());
        user.setProfileSummary(dto.getProfileSummary());
        user.setSkills(dto.getSkills());

        User saved = userRepository.save(user);


        // Send event to Kafka
        UserDocument userDoc = new UserDocument();
        userDoc.setId(saved.getId().toString());
        userDoc.setFullName(saved.getFullName());
        userDoc.setEmail(saved.getEmail());
        userDoc.setPhone(saved.getPhone());
        userDoc.setRole(saved.getRole());
        userDoc.setLocation(saved.getLocation());
        userDoc.setResumeUrl(saved.getResumeUrl());
        userDoc.setProfileSummary(saved.getProfileSummary());
        userDoc.setSkills(saved.getSkills());

        userEventProducer.publishUser(userDoc);

        return mapToDTO(saved);
    }


    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::mapToDTO).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponseDTO mapToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setLocation(user.getLocation());
        dto.setResumeUrl(user.getResumeUrl());
        dto.setProfileSummary(user.getProfileSummary());
        dto.setSkills(user.getSkills());
        return dto;
    }
}
