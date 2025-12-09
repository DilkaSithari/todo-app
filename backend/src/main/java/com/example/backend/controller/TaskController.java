package com.example.backend.controller;

import com.example.backend.model.Task;
import com.example.backend.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskservice;

    @PostMapping
    public Task add(@RequestBody Task t) {
        log.info("HIT - /api/tasks Add Task : {}", t);
        return taskservice.create(t);
    }

    @GetMapping
    public List<Task> getRecent() {
        return taskservice.getRecent();
    }

    @PutMapping("/{id}/done")
    public void markDone(@PathVariable Long id) {
        taskservice.markDone(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {

        String message = taskservice.deleteTask(id);

        if ("Task not found".equals(message)) {
            return ResponseEntity.status(404).body(message);
        }

        return ResponseEntity.ok(message);
    }
}

