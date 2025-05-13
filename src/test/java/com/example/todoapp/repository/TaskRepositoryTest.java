package com.example.todoapp.repository;

import com.example.todoapp.model.Task;
import com.example.todoapp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles; // Lägg till denna rad

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test") // Lägg till denna rad för att använda testprofilen
public class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findByUserId_ReturnsTasks() {
        User user = new User();
        user.setUsername("testuser");
        entityManager.persist(user);

        Task task = new Task();
        task.setUser(user);
        task.setDescription("Test task");
        entityManager.persist(task);

        List<Task> found = taskRepository.findByUserId(user.getId());
        assertThat(found).hasSize(1);
        assertThat(found.get(0).getDescription()).isEqualTo("Test task");
    }
}
