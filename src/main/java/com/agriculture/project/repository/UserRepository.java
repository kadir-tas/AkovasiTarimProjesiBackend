package com.agriculture.project.repository;

import com.agriculture.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsernameOrUserEmail(String username, String userEmail);

    public User findByUsername(String username);

    public boolean existsByUsername(String username);

    public boolean existsByUserEmail(String userEmail);


}