package com.bellolucas.tasks_management.repositories;

import com.bellolucas.tasks_management.entities.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
