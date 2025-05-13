package com.example.todoapp.controller;

import com.example.todoapp.model.Task;
import com.example.todoapp.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createTask_ReturnsCreatedTask() throws Exception {
        Task task = new Task();
        task.setDescription("Test task");
        when(taskService.createTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test task"));
    }

    @Test
    void getTasksByUser_ReturnsTaskList() throws Exception {
        Task task = new Task();
        task.setDescription("Test task");
        when(taskService.getTasksByUserId(1L)).thenReturn(List.of(task));

        mockMvc.perform(get("/api/tasks/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("Test task"));
    }
}