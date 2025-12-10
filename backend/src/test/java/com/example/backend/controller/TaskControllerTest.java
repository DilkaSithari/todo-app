package com.example.backend.controller;

import com.example.backend.model.Task;
import com.example.backend.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void shouldCreateTask() throws Exception {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test");
        task.setDescription("Desc");

        when(taskService.create(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/api/tasks")
                        .contentType("application/json")
                        .content("""
                    {"title":"Test","description":"Desc"}
                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test"));
    }
}
