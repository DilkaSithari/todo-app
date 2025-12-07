package com.example.backend.controller;

import com.example.backend.model.Task;
import com.example.backend.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
@Slf4j
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping
    public Task add(@RequestBody Task t) {
        log.info("HIT - /api/tasks Add Task : {}", t);
        return service.create(t);
    }

    @GetMapping
    public List<Task> getRecent() {
        return service.getRecent();
    }

    @PutMapping("/{id}/done")
    public void markDone(@PathVariable Long id) {
        service.markDone(id);
    }
}

