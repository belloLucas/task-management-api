package com.bellolucas.tasks_management.dto.task;

import com.bellolucas.tasks_management.entities.task.Priority;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateTaskDTO(
        @NotNull
        String title,

        String description,

        @NotNull
        Priority priority,

        @NotNull
        Long assignee,

        @NotNull
        Boolean completed,

        @NotNull
        LocalDateTime deadline
) {
}
