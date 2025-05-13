package com.example.todoapp.service;

import com.example.todoapp.model.User;
import com.example.todoapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_SavesUser() {
        User user = new User();
        user.setUsername("test");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.createUser(user);
        assertEquals("test", saved.getUsername());
    }
}