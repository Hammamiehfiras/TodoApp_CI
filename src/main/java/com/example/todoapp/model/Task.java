package com.example.todoapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Task tillhör en User
}