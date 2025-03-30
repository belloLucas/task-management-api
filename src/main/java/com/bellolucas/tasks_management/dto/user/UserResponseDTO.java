package com.bellolucas.tasks_management.dto.user;

import com.bellolucas.tasks_management.entities.user.User;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
