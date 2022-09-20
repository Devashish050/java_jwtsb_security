package com.javajwt.java_jwtsb_security;

import com.javajwt.java_jwtsb_security.model.User;
import com.javajwt.java_jwtsb_security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class JavaJwtsbSecurityApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    static Random random = new Random();

    public void createUser() {

        User user = new User();
        Long id = new Long(random.nextInt(100));
        user.setId(id);
        user.setEmail("user" + id + "@gmail.com");
        user.setUsername("user" + id);
        user.setPassword("user" + id);
        user.setEnabled(true);
        user.setRole("admin");

        User save = this.userRepository.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaJwtsbSecurityApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        createUser();
    }
}
