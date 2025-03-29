package com.bellolucas.tasks_management.entities.task;

import com.bellolucas.tasks_management.entities.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "id")
    private User assignee;

    private LocalDateTime deadline;
    private Boolean completed;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
