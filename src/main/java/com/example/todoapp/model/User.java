package com.example.todoapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "app_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;  // Enkel lagring (ingen hash för enkelhet)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;  // En användare har många tasks
}
