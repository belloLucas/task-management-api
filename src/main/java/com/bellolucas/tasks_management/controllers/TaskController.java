package com.bellolucas.tasks_management.controllers;

import com.bellolucas.tasks_management.dto.task.CreateTaskDTO;
import com.bellolucas.tasks_management.dto.task.UpdateTaskDTO;
import com.bellolucas.tasks_management.entities.task.Task;
import com.bellolucas.tasks_management.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid CreateTaskDTO data) {
        Task task = taskService.createTask(data);
        return ResponseEntity.status(201).body(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody @Valid UpdateTaskDTO data) {
        Task updatedTask = taskService.updateTask(id, data);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
