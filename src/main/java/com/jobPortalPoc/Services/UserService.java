package com.jobPortalPoc.Services;

import com.jobPortalPoc.DTO.UserResponseDTO;


import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserResponseDTO dto);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    void deleteUser(Long id);
}
