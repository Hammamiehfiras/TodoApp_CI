package com.example.todoapp.repository;

import com.example.todoapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername_ReturnsUser() {
        User user = new User();
        user.setUsername("testuser");
        userRepository.save(user);

        User found = userRepository.findByUsername("testuser");
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("testuser");
    }
}