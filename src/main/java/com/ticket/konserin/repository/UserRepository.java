package com.ticket.konserin.repository;

import com.ticket.konserin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{
    Optional<User> findByEmail(String email);
    User findById(User userId);
}
