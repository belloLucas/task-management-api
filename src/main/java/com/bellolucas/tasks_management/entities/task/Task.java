package com.bellolucas.tasks_management.entities.task;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated()
    private Priority priority;

    private Long assignee;
    private Date deadline;
    private Boolean completed;
    private Date created_at;
    private Date updated_at;
}
