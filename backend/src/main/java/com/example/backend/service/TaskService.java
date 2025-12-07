package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public Task create(Task t) {
        t.setCompleted(false);
        t.setCreatedAt(LocalDateTime.now());
        return repository.save(t);
    }

    public List<Task> getRecent() {
        return repository.findTop5ByCompletedOrderByCreatedAtDesc(false);
    }

    public void markDone(Long id) {
        Task t = repository.findById(id).orElseThrow();
        t.setCompleted(true);
        repository.save(t);
    }
}

