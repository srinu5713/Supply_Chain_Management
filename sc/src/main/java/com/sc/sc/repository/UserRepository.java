package com.sc.sc.repository;

import com.sc.sc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods if needed
    User findByUsernameAndPassword(String username, String password);
}