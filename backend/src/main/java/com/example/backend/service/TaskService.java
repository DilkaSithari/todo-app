package com.example.backend.service;

import com.example.backend.model.Task;
import com.example.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task create(Task t) {
        t.setCompleted(false);
        t.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(t);
    }

    public List<Task> getRecent() {
        return taskRepository.findTop5ByCompletedOrderByCreatedAtDesc(false);
    }

    public void markDone(Long id) {
        Task t = taskRepository.findById(id).orElseThrow();
        t.setCompleted(true);
        taskRepository.save(t);
    }

    public String deleteTask(Long id) {

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty()) {
            return "Task not found";
        }

        taskRepository.deleteById(id);
        return "Task deleted successfully";
    }
}

