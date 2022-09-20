package com.javajwt.java_jwtsb_security.repo;

import com.javajwt.java_jwtsb_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //this method will return the username of user
    public User findByUsername(String username);
}
