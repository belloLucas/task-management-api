package com.bellolucas.tasks_management.repositories;

import com.bellolucas.tasks_management.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
