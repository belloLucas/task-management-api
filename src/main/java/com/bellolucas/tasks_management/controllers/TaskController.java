package com.bellolucas.tasks_management.controllers;

import com.bellolucas.tasks_management.dto.task.CreateTaskDTO;
import com.bellolucas.tasks_management.entities.task.Task;
import com.bellolucas.tasks_management.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(CreateTaskDTO data) {
        return taskService.createTask(data);
    }
}
