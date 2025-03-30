package com.bellolucas.tasks_management.services;

import com.bellolucas.tasks_management.dto.task.CreateTaskDTO;
import com.bellolucas.tasks_management.entities.task.Task;
import com.bellolucas.tasks_management.entities.user.User;
import com.bellolucas.tasks_management.repositories.TaskRepository;
import com.bellolucas.tasks_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(@RequestBody CreateTaskDTO data) {
        User assignee = userRepository.findById(data.assignee()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Task task = new Task(data, assignee);
        return taskRepository.save(task);
    }

    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
