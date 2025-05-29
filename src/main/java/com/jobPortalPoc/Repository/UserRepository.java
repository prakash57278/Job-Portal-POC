package com.jobPortalPoc.Repository;


import com.jobPortalPoc.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here later (e.g., findByEmail)
}
