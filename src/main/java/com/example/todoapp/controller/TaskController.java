package com.example.todoapp.controller;

import com.example.todoapp.model.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PatchMapping("/{taskId}/toggle")
    public Task toggleTaskCompletion(@PathVariable Long taskId) {
        return taskService.toggleTaskCompletion(taskId);
    }
}