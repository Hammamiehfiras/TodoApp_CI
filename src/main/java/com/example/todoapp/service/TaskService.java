package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task toggleTaskCompletion(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }
}