package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask_SavesTask() {
        Task task = new Task();
        task.setDescription("Test");
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task saved = taskService.createTask(task);
        assertEquals("Test", saved.getDescription());
        verify(taskRepository).save(task);
    }

    @Test
    void getTasksByUser_ReturnsTasks() {
        Task task = new Task();
        when(taskRepository.findByUserId(1L)).thenReturn(List.of(task));

        List<Task> tasks = taskService.getTasksByUserId(1L);
        assertEquals(1, tasks.size());
    }
}